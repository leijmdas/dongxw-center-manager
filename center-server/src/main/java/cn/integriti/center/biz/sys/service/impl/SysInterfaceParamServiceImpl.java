package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.support.validation.BeanValidator;
import cn.integriti.center.biz.sys.dao.SysInterfaceParamMapper;
import cn.integriti.center.biz.sys.domain.SysInterfaceParam;
import cn.integriti.center.biz.sys.service.SysInterfaceParamService;
import cn.integriti.center.core.util.StringUtil;
/**
 * SysInterfaceParamServiceImpl
 * @author generator
 * @date 2016年06月06日
 */
@Service
public class SysInterfaceParamServiceImpl implements SysInterfaceParamService {
	
	@Autowired
	private SysInterfaceParamMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysInterfaceParam entity){
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		entity.setUpdateBy(entity.getCreateBy());
		entity.setUpdateOn(entity.getCreateOn());
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysInterfaceParam entity){
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
	public SysInterfaceParam findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysInterfaceParam
	 * @return
	 */
	public List<SysInterfaceParam> findByNotNullProps(SysInterfaceParam entity){
		
		SelectStatement<SysInterfaceParam> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysInterfaceParam
	 * @return
	 */
	public void updateNotNullPropsById(SysInterfaceParam entity){
		
		UpdateStatement<SysInterfaceParam> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	private void checkEntity(SysInterfaceParam entity) {
		BeanValidator.propertyCheck(entity);
		/*SysInterfaceParam tmp = this.findByCode(entity.getDomainCode());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("编码已存在[code:" + entity.getDomainCode() + "]");
		}*/
	}

	@Override
	public List<SysInterfaceParam> findByInterfaceId(Integer interfaceId) {
		SysInterfaceParam.EntityNode n = SysInterfaceParam.EntityNode.INSTANCE;
		SelectStatement<SysInterfaceParam> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.interfaceId.eq(interfaceId));
		return this.repo.selectByStatement(st);
		
	}
	public void deleteByInterfaceId(Integer intfId) {
		SysInterfaceParam.EntityNode n = SysInterfaceParam.EntityNode.INSTANCE;
		SelectStatement<SysInterfaceParam> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.interfaceId.eq(intfId));
		this.repo.deleteByRestrictions(st.restrictions());
	}
	@Transactional
	@Override
	public void flushInterfaceParams(Integer intifId, List<SysInterfaceParam> sysInterfaceParams) {
		this.deleteByInterfaceId(intifId);
		if(sysInterfaceParams == null || sysInterfaceParams.isEmpty()){
			return ;
		}
		Integer opBy = CurrentRequestContext.getOpBy();
		Date now = new Date();
		Iterator<SysInterfaceParam> it = sysInterfaceParams.iterator();
		while(it.hasNext()){
			SysInterfaceParam intfParam = it.next();
			if(StringUtil.isBlank(intfParam.getParamKey())){
				it.remove();
			} else {
				intfParam.setInterfaceId(intifId);
				intfParam.setCreateBy(opBy);
				intfParam.setCreateOn(now);
				intfParam.setUpdateBy(opBy);
				intfParam.setUpdateOn(now);
			}
		}
		if(sysInterfaceParams.size()>0){
			this.repo.batchInsert(sysInterfaceParams);
		}
		
	}

	
	/*public SysInterfaceParam findByCode(String code) {
		SysInterfaceParam.EntityNode n = SysInterfaceParam.EntityNode.INSTANCE;
		SelectStatement<SysInterfaceParam> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.domainCode.eq(code));
		return CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
	}*/
}
