package cn.kunlong.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysRoleResourceMapper;
import cn.kunlong.center.biz.sys.domain.SysRoleResource;
import cn.kunlong.center.biz.sys.service.SysRoleResourceService;

/**
 * SysRoleResourceServiceImpl
 * 
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

	@Autowired
	private SysRoleResourceMapper repo;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysRoleResource entity) {
		Integer logBy = CurrentRequestContext.getOpBy();

		entity.setCreateBy(logBy);
		entity.setCreateOn(new Date());
		entity.setOpOn(entity.getCreateOn());
		entity.setOpBy(logBy);

		repo.insert(entity);
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysRoleResource entity) {
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
	public SysRoleResource findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysRoleResource
	 * @return
	 */
	public List<SysRoleResource> findByNotNullProps(SysRoleResource entity) {

		SelectStatement<SysRoleResource> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysRoleResource
	 * @return
	 */
	public void updateNotNullPropsById(SysRoleResource entity) {

		UpdateStatement<SysRoleResource> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
}
