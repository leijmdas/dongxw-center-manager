package cn.kunlong.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.support.validation.BeanValidator;
import cn.kunlong.center.biz.sys.dao.SysDictMapper;
import cn.kunlong.center.biz.sys.domain.SysDict;
import cn.kunlong.center.biz.sys.domain.SysDictItem;
import cn.kunlong.center.biz.sys.queryParam.SysDictQueryParam;
import cn.kunlong.center.biz.sys.service.SysDictService;
/**
 * SysDictServiceImpl
 * @author generator
 * @date 2015年12月15日
 */
@Service
public class SysDictServiceImpl implements SysDictService {
	
	@Autowired
	private SysDictMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDict entity){
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		this.checkEntity(entity);
		
		repo.insert(entity);
	}

	private void checkEntity(SysDict entity) {
		BeanValidator.propertyCheck(entity);
		SysDict tmp = this.findByCode(entity.getCorpId(),entity.getDictCode());
		if(tmp!=null && !tmp.getId().equals(entity.getId())){
			throw new ValidationException("编码已存在");
		}
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDict entity){
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
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
	public SysDict findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysDict
	 * @return
	 */
	public List<SysDict> findByNotNullProps(SysDict entity){
		
		SelectStatement<SysDict> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysDict
	 * @return
	 */
	public void updateNotNullPropsById(SysDict entity){
		
		UpdateStatement<SysDict> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysDict> findByQueryParam(SysDictQueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysDictQueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public SysDict findByCode(Integer corpId,String code) {
		return this.repo.findByCode(corpId,code);
	}

	@Override
	public List<SysDictItem> findByDictDetails(Integer corpId,String code) {
		SysDict dict = this.repo.findByCode(corpId,code);
		Assert.notNull(dict, "字典不存在!");
		return dict.getItems();
	}
}
