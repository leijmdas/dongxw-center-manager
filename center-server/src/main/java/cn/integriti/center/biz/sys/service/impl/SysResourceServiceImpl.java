package cn.integriti.center.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.dao.SysResourceMapper;
import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.service.SysResourceGroupService;
import cn.integriti.center.biz.sys.service.SysResourceService;
import cn.integriti.center.core.util.CollectionUtil;

/**
 * SysResourceServiceImpl
 * 
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	private SysResourceMapper repo;
	
	@Autowired
	private SysResourceGroupService sysResourceGroupService;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysResource entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());

		entity.setOpOn(entity.getCreateOn());
		entity.setCreateBy(entity.getOpBy());
		entity.setCreateOn(entity.getOpOn());
		this.checkEntity(entity);
		repo.insert(entity);
	}

	private void checkEntity(SysResource entity) {
		SysResource tmp = this.findByCode(entity.getResCode());
		if(tmp!=null && !tmp.getId().equals(entity.getId())){
			throw new ValidationException("编码已存在[code:"+entity.getResCode()+"]");
		}
		//冗余type
		SysResourceGroup group = this.sysResourceGroupService.findById(entity.getGroupId());
		entity.setType(group.getGroupType());
	}
	SysResource findByCode(String code){
		SysResource.EntityNode n = SysResource.EntityNode.INSTANCE;
		SelectStatement<SysResource> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.resCode.eq(code));
		List<SysResource> list = this.repo.selectByStatement(st);
		return CollectionUtil.uniqueResult(list);
	}
	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysResource entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());

		entity.setOpOn(entity.getCreateOn());
		entity.setCreateBy(entity.getOpBy());
		entity.setCreateOn(entity.getOpOn());
		this.checkEntity(entity);
		repo.update(entity);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk) {
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysResource findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysResource
	 * @return
	 */
	public List<SysResource> findByNotNullProps(SysResource entity) {

		SelectStatement<SysResource> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysResource
	 * @return
	 */
	public void updateNotNullPropsById(SysResource entity) {

		UpdateStatement<SysResource> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysResource> findByQueryParam(SysResource.QueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysResource.QueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public List<SysResourceGroup> queryGroupAndResources() {
		SysResource.QueryParam qp = new SysResource.QueryParam();
		qp.setLimit(-1);
		
		List<SysResource> srs = this.findByQueryParam(qp);
		if(srs == null ||srs.size()<1) return null;
		Map<Integer, List<SysResource>> srMap = srs.stream().collect(Collectors.groupingBy(SysResource::getGroupId));
		
		List<SysResourceGroup> srgs = sysResourceGroupService.findByIds(new ArrayList<>(srMap.keySet()));
		srgs.forEach(sr -> sr.setSysResources(srMap.get(sr.getId())));

		return srgs;
	}
	
	@Override
	public List<SysResource> findByIdsWithGroup(List<Integer> ids) {
		if (ids == null || ids.isEmpty())
			return Arrays.asList();
		return this.repo.findByIdsWithGroup(ids);
	}

	@Override
	public List<SysResource> findMicroList(SysResource.QueryParam qp) {
		SysResource.EntityNode n = SysResource.EntityNode.INSTANCE;
		SelectStatement<SysResource> st = StatementBuilder.buildSelect(n);
		if (qp.getIds() != null && !qp.getIds().isEmpty()) {
			st.getRestrictions().add(n.id.in(qp.getIds()));
		} else {
			return this.findByQueryParam(qp);
		}
		return repo.selectByStatement(st);
	}
}
