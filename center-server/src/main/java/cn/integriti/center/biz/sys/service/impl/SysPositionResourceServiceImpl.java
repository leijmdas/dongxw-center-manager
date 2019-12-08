package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.dao.SysPositionResourceMapper;
import cn.integriti.center.biz.sys.domain.SysPositionResource;
import cn.integriti.center.biz.sys.service.SysPositionResourceService;

/**
 * SysPositionResourceServiceImpl
 * 
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysPositionResourceServiceImpl implements SysPositionResourceService {

	@Autowired
	private SysPositionResourceMapper repo;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysPositionResource entity) {
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
	public void update(SysPositionResource entity) {
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
	public SysPositionResource findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysPositionResource
	 * @return
	 */
	public List<SysPositionResource> findByNotNullProps(SysPositionResource entity) {

		SelectStatement<SysPositionResource> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysPositionResource
	 * @return
	 */
	public void updateNotNullPropsById(SysPositionResource entity) {

		UpdateStatement<SysPositionResource> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
}
