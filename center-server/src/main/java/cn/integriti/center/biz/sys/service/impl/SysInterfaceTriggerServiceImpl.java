package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.dao.SysInterfaceTriggerMapper;
import cn.integriti.center.biz.sys.domain.SysInterfaceTrigger;
import cn.integriti.center.biz.sys.service.SysInterfaceTriggerService;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SysInterfaceTriggerServiceImpl
 * @author generator
 * @date 2016年06月06日
 */
@Service
public class SysInterfaceTriggerServiceImpl implements SysInterfaceTriggerService {
	
	@Autowired
	private SysInterfaceTriggerMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysInterfaceTrigger entity){
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
	public void update(SysInterfaceTrigger entity){
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
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
	public SysInterfaceTrigger findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysInterfaceTrigger
	 * @return
	 */
	public List<SysInterfaceTrigger> findByNotNullProps(SysInterfaceTrigger entity){
		
		SelectStatement<SysInterfaceTrigger> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysInterfaceTrigger
	 * @return
	 */
	public void updateNotNullPropsById(SysInterfaceTrigger entity){
		
		UpdateStatement<SysInterfaceTrigger> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	@Override
	public long deleteTriggerIdInterfaceId(SysInterfaceTrigger entity){
		return repo.deleteTriggerIdInterfaceId(entity);
	}

	@Override
	public List<SysInterfaceTrigger> findByInterfaceId(Integer id) {
		SysInterfaceTrigger.EntityNode n = SysInterfaceTrigger.EntityNode.INSTANCE;
		SelectStatement<SysInterfaceTrigger> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.interfaceId.eq(id));
		return this.repo.selectByStatement(st);
	}
}
