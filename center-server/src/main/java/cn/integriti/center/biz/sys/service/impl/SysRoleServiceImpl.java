package cn.integriti.center.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.support.validation.BeanValidator;
import cn.integriti.center.biz.sys.dao.SysRoleMapper;
import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.domain.SysRole;
import cn.integriti.center.biz.sys.domain.SysRoleResource;
import cn.integriti.center.biz.sys.service.SysResourceGroupService;
import cn.integriti.center.biz.sys.service.SysResourceService;
import cn.integriti.center.biz.sys.service.SysRoleResourceService;
import cn.integriti.center.biz.sys.service.SysRoleService;

/**
 * SysRoleServiceImpl
 * 
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper repo;

	@Autowired
	private SysResourceGroupService sysResourceGroupService;
	@Autowired
	private SysResourceService sysResourceService;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;

	public static final String ROLE_ROOT = "root";

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysRole entity) {
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		entity.setOpOn(entity.getCreateOn());
		entity.setOpBy(entity.getCreateBy());
		entity.setRoleCode(UUID.randomUUID().toString().replaceAll("-", ""));
		this.checkEntity(entity);

		repo.insert(entity);
	}

	private void checkEntity(SysRole entity) {
		BeanValidator.propertyCheck(entity);
		if (ROLE_ROOT.equals(entity.getRoleCode())) {
			throw new ValidationException("此角色不允许编辑");
		}
		SysRole tmp = this.findByCode(entity.getCorpId(), entity.getRoleCode());
		if(tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("编码已存在");
		}
		
	}

	private SysRole findByCode(Integer corpId,String code) {
		SysRole.EntityNode n = SysRole.EntityNode.INSTANCE;
		SelectStatement<SysRole> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.corpId.eq(corpId)).add(n.roleCode.eq(code));
		
		return this.repo.selectByStatement(st).stream().findFirst().orElse(null);
	}
	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysRole entity) {

		entity.setOpOn(new Date());
		entity.setOpBy(CurrentRequestContext.getOpBy());

		this.checkEntity(entity);

		repo.update(entity);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk) {
		SysRole entity = this.repo.selectByPK(pk);
		if (ROLE_ROOT.equals(entity.getRoleCode())) {
			throw new ValidationException("此角色不允许删除");
		}
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysRole findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysRole
	 * @return
	 */
	public List<SysRole> findByNotNullProps(SysRole entity) {

		SelectStatement<SysRole> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysRole
	 * @return
	 */
	public void updateNotNullPropsById(SysRole entity) {

		UpdateStatement<SysRole> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<Integer> findResourceIds(Integer roleId) {
		SysRoleResource param = new SysRoleResource();
		param.setRoleId(roleId);

		List<SysRoleResource> oldResources = this.sysRoleResourceService.findByNotNullProps(param);
		return oldResources.stream().map(SysRoleResource::getResourceId).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public void assignRoleResources(Integer roleId, List<Integer> resIds) {
		Set<Integer> dstResIds = new HashSet<Integer>();
		if (resIds != null) {
			dstResIds.addAll(resIds);
		}
		SysRoleResource param = new SysRoleResource();
		param.setRoleId(roleId);

		List<SysRoleResource> oldResources = this.sysRoleResourceService.findByNotNullProps(param);
		// Set<Integer> delIds = new HashSet<Integer>();
		if (oldResources != null) {
			Iterator<SysRoleResource> it = oldResources.iterator();
			while (it.hasNext()) {
				SysRoleResource tmp = it.next();
				if (dstResIds.contains(tmp.getResourceId())) {
					dstResIds.remove(tmp.getResourceId());
				} else {
					// delIds.add(tmp.getId());
					sysRoleResourceService.deleteById(tmp.getId());
				}
			}
		}

		List<SysResource> srs = sysResourceService.findByIdsWithGroup(new ArrayList<>(dstResIds));
		Map<Integer, Integer> domainMap = srs.stream().collect(Collectors.toMap(SysResource::getId, sr -> sr.getSysResourceGroup().getDomainId()));
		dstResIds.forEach(id -> {
			SysRoleResource sr = new SysRoleResource();
			sr.setResourceId(id);
			sr.setRoleId(roleId);
			sr.setDomainId(domainMap.get(id));
			this.sysRoleResourceService.save(sr);
		});
	}

	@Override
	public List<SysResourceGroup> findRoleResources(List<Integer> roleIds) {
		Assert.isTrue(roleIds != null && roleIds.size() > 0, "集合元素不能为空");
		return this.sysResourceGroupService.findRoleResources(roleIds);
	}

	@Override
	public List<SysResource> findRoleResources(Integer roleId) {
		List<SysResourceGroup> resGroupList = this.findRoleResources(Arrays.asList(roleId));
		List<SysResource> rs = new ArrayList<SysResource>();
		for (SysResourceGroup resGroup : resGroupList) {
			if (resGroup.getSysResources() != null) {
				rs.addAll(resGroup.getSysResources());
			}
		}
		return rs;
	}

//	private SelectStatement<SysRole> createStatement(SysRole.QueryParam queryParam) {
//		SysRole.EntityNode n = SysRole.EntityNode.INSTANCE;
//
//		SelectStatement<SysRole> st = StatementBuilder.buildSelect(n);
//		SysRole p = queryParam.getParam();
//		if (p != null) {
//			if (p.getStatus() != null) {
//				st.restrictions().add(n.status.eq(p.getStatus()));
//			}
//			if (StringUtils.isNotBlank(p.getRoleCode())) {
//				st.restrictions().add(n.roleCode.eq(p.getRoleCode()));
//			}
//			if (StringUtils.isNotBlank(p.getRoleName())) {
//				st.restrictions().add(n.roleName.like("%" + p.getRoleName() + "%"));
//			}
//
//		}
//		return st;
//	}

	@Override
	public List<SysRole> findByQueryParam(SysRole.QueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysRole.QueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public List<SysRole> findAll() {
		SysRole.EntityNode n = SysRole.EntityNode.INSTANCE;
		SelectStatement<SysRole> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}

	@Override
	public List<SysRole> findUserRoles(Integer userId, Integer type) {
		return this.repo.findUserRoles(userId, type);
	}

	@Override
	public List<SysRole> findMicroList(SysRole.QueryParam qp) {
		SysRole.EntityNode n = SysRole.EntityNode.INSTANCE;
		SelectStatement<SysRole> st = StatementBuilder.buildSelect(n);
		if (qp.getIds() != null && !qp.getIds().isEmpty()) {
			st.getRestrictions().add(n.id.in(qp.getIds()));
		} else {
			return this.findByQueryParam(qp);
		}
		return repo.selectByStatement(st);
	}

	@Override
	public List<SysRole> findByIds(List<Integer> ids) {
		SysRole.EntityNode n = SysRole.EntityNode.INSTANCE;
		
		SelectStatement<SysRole> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.id.in(ids));
		
		return this.repo.selectByStatement(st);
	}
}
