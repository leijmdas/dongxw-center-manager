package cn.kunlong.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.support.validation.BeanValidator;
import cn.kunlong.center.biz.sys.dao.SysDomainMapper;
import cn.kunlong.center.biz.sys.domain.SysDomain;
import cn.kunlong.center.biz.sys.queryParam.SysDomainQueryParam;
import cn.kunlong.center.biz.sys.service.SysDomainService;
import cn.kunlong.center.core.util.CollectionUtil;

/**
 * SysDomainServiceImpl
 * 
 * @author generator
 * @date 2016年05月04日
 */
@Service
public class SysDomainServiceImpl implements SysDomainService {

	@Autowired
	private SysDomainMapper repo;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysDomain entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		this.checkEntity(entity);
		repo.insert(entity);
	}

	private void checkEntity(SysDomain entity) {
		BeanValidator.propertyCheck(entity);
		SysDomain tmp = this.findByCode(entity.getDomainCode());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("编码已存在[code:" + entity.getDomainCode() + "]");
		}
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysDomain entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
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
	public SysDomain findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysDomain
	 * @return
	 */
	public List<SysDomain> findByNotNullProps(SysDomain entity) {

		SelectStatement<SysDomain> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysDomain
	 * @return
	 */
	public void updateNotNullPropsById(SysDomain entity) {

		UpdateStatement<SysDomain> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysDomain> findByQueryParam(SysDomainQueryParam queryParam) {
		SelectStatement<SysDomain> st = this.createStatement(queryParam);
		return this.repo.selectByStatement(st);
	}

	private SelectStatement<SysDomain> createStatement(SysDomainQueryParam queryParam) {
		SysDomain.EntityNode n = SysDomain.EntityNode.INSTANCE;
		SelectStatement<SysDomain> st = StatementBuilder.buildSelect(n);
		SysDomain p = queryParam.getParam();
		if (org.apache.commons.lang3.StringUtils.isNotBlank(p.getDomainName())) {
			st.restrictions().add(n.domainName.like("%" + p.getDomainName() + "%"));
		}

		st.setPageRange(queryParam.getStart(), queryParam.getLimit());
		return st;
	}

	@Override
	public long countByQueryParam(SysDomainQueryParam queryParam) {
		SelectStatement<SysDomain> st = this.createStatement(queryParam);
		return this.repo.countByRestrictions(st.restrictions());
	}

	public SysDomain findByCode(String code) {
		SysDomain.EntityNode n = SysDomain.EntityNode.INSTANCE;
		SelectStatement<SysDomain> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.domainCode.eq(code));
		return CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
	}

	@Override
	public List<SysDomain> findAll() {
		SysDomain.EntityNode n = SysDomain.EntityNode.INSTANCE;
		SelectStatement<SysDomain> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}
}
