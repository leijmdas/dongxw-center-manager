package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.support.validation.BeanValidator;
import cn.integriti.center.biz.sys.dao.SysUserRoleMapper;
import cn.integriti.center.biz.sys.domain.SysUserRole;
import cn.integriti.center.biz.sys.service.SysUserRoleService;
/**
 * SysUserRoleServiceImpl
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
	private SysUserRoleMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysUserRole entity){
		Integer logBy = CurrentRequestContext.getOpBy();

		entity.setOpOn(new Date());
		entity.setOpBy(logBy);
		this.checkEntity(entity);
		repo.insert(entity);
	}

	private void checkEntity(SysUserRole entity) {
		BeanValidator.propertyCheck(entity);
		SysUserRole tmp = this.findUnique(entity.getUserId(), entity.getRoleId());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("角色已被分配");
		}
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysUserRole entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysUserRole findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysUserRole
	 * @return
	 */
	public List<SysUserRole> findByNotNullProps(SysUserRole entity){
		
		SelectStatement<SysUserRole> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysUserRole
	 * @return
	 */
	public void updateNotNullPropsById(SysUserRole entity){
		
		UpdateStatement<SysUserRole> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysUserRole> findByQueryParam(SysUserRole.QueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public SysUserRole findUnique(Integer userId, Integer roleId) {
		SysUserRole.EntityNode n = SysUserRole.EntityNode.INSTANCE;
		SelectStatement<SysUserRole> st = StatementBuilder.buildSelect(n);
		st.getRestrictions().add(n.userId.eq(userId)).add(n.roleId.eq(roleId));
		return repo.selectByStatement(st).stream().findFirst().orElse(null);
	}
}
