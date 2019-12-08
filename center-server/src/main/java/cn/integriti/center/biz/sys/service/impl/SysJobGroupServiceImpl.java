package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.dao.SysJobGroupMapper;
import cn.integriti.center.biz.sys.domain.SysJobGroup;
import cn.integriti.center.biz.sys.domain.SysJobGroup.QueryParam;
import cn.integriti.center.biz.sys.queryParam.SysJobGroupParam;
import cn.integriti.center.biz.sys.service.SysJobGroupService;
/**
 * SysJobGroupServiceImpl
 * @author generator
 * @date 2016年06月05日
 */
@Service
public class SysJobGroupServiceImpl implements SysJobGroupService {
	
	@Autowired
	private SysJobGroupMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysJobGroup entity){
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		entity.setCreateBy(entity.getUpdateBy());
		entity.setCreateOn(entity.getUpdateOn());
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysJobGroup entity){
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
	public SysJobGroup findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysJobGroup
	 * @return
	 */
	public List<SysJobGroup> findByNotNullProps(SysJobGroup entity){
		
		SelectStatement<SysJobGroup> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysJobGroup
	 * @return
	 */
	public void updateNotNullPropsById(SysJobGroup entity){
		
		UpdateStatement<SysJobGroup> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	@Override
	public int updateClause(SysJobGroup sysJobGroup){
		return this.repo.updateClause(sysJobGroup);
	}
	
	@Override
	public List<SysJobGroup> findAll() {
		SysJobGroup.EntityNode n = SysJobGroup.EntityNode.INSTANCE;
		SelectStatement<SysJobGroup> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}

	@Override
	public List<SysJobGroup> findByQueryParam(QueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(QueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public List<SysJobGroup> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
}
