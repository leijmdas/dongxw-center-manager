package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.dao.SysUserPositionMapper;
import cn.integriti.center.biz.sys.domain.SysUserPosition;
import cn.integriti.center.biz.sys.service.SysUserPositionService;
/**
 * SysUserPositionServiceImpl
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysUserPositionServiceImpl implements SysUserPositionService {
	
	@Autowired
	private SysUserPositionMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysUserPosition entity){
		Integer logBy = CurrentRequestContext.getOpBy();

		entity.setOpOn(new Date());
		entity.setOpBy(logBy);

		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysUserPosition entity){
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
	public SysUserPosition findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysUserPosition
	 * @return
	 */
	public List<SysUserPosition> findByNotNullProps(SysUserPosition entity){
		
		SelectStatement<SysUserPosition> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysUserPosition
	 * @return
	 */
	public void updateNotNullPropsById(SysUserPosition entity){
		
		UpdateStatement<SysUserPosition> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
}
