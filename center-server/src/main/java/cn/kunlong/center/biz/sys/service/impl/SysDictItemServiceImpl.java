package cn.kunlong.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.support.validation.BeanValidator;
import cn.kunlong.center.biz.sys.dao.SysDictDetailMapper;
import cn.kunlong.center.biz.sys.dao.SysDictMapper;
import cn.kunlong.center.biz.sys.domain.SysDict;
import cn.kunlong.center.biz.sys.domain.SysDictItem;
import cn.kunlong.center.biz.sys.queryParam.SysDictDetailQueryParam;
import cn.kunlong.center.biz.sys.service.SysDictItemService;
import cn.kunlong.center.core.util.CollectionUtil;

/**
 * SysDictDetailServiceImpl
 * 
 * @author generator
 * @date 2015年12月15日
 */
@Service
public class SysDictItemServiceImpl implements SysDictItemService {

	@Autowired
	private SysDictDetailMapper repo;
	
	@Autowired 
	private SysDictMapper sysDictMapper;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysDictItem entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		this.checkEntity(entity);

		repo.insert(entity);
	}

	private void checkEntity(SysDictItem entity) {
		BeanValidator.propertyCheck(entity);
		SysDictItem tmp = this.findByCode(entity.getDictId(), entity.getCode());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("编码已存在");
		}
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysDictItem entity) {
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
	public SysDictItem findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysDictItem
	 * @return
	 */
	public List<SysDictItem> findByNotNullProps(SysDictItem entity) {

		SelectStatement<SysDictItem> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysDictItem
	 * @return
	 */
	public void updateNotNullPropsById(SysDictItem entity) {

		UpdateStatement<SysDictItem> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	private SelectStatement<SysDictItem> createSelectSt(SysDictDetailQueryParam queryParam) {
		SysDictItem.EntityNode n = SysDictItem.EntityNode.INSTANCE;
		SelectStatement<SysDictItem> st = StatementBuilder.buildSelect(n);

		SysDictItem p = queryParam.getParam();
		if (p != null) {
			if (p.getDictId() != null) {
				st.restrictions().add(n.dictId.eq(p.getDictId()));
			}
			if (StringUtils.isNotBlank(p.getCode())) {
				st.restrictions().add(n.code.eq(p.getCode()));
			}
			if (StringUtils.isNotBlank(p.getName())) {
				st.restrictions().add(n.name.like("%" + p.getName() + "%"));
			}
		}
		if (queryParam.getLimit() != null && queryParam.getLimit() > 0) {
			st.setPageRange(queryParam.getStart(), queryParam.getLimit());
		}
		st.orderby().asc(n.orderNum).desc(n.opOn);
		return st;
	}

	@Override
	public List<SysDictItem> findByQueryParam(SysDictDetailQueryParam queryParam) {
		SelectStatement<SysDictItem> st = this.createSelectSt(queryParam);
		return this.repo.selectByStatement(st);
	}

	@Override
	public long countByQueryParam(SysDictDetailQueryParam queryParam) {
		SelectStatement<SysDictItem> st = this.createSelectSt(queryParam);
		return this.repo.countByRestrictions(st.getRestrictions());
	}

	private SysDictItem findByCode(Integer dictId, String code) {
		SysDictItem.EntityNode n = SysDictItem.EntityNode.INSTANCE;
		SelectStatement<SysDictItem> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.dictId.eq(dictId)).add(n.code.eq(code));
		return CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
	}

	@Override
	public SysDictItem findDictDetail(Integer corpId,String dictCode, String code) {
		SysDict dict = sysDictMapper.findByCode(corpId,dictCode);
		Assert.notNull(dict,"字典不存在[code:"+dictCode+"]");
		
		return findByCode(dict.getId(),code);
	}

	@Override
	public List<SysDictItem> findByDictId(Integer id) {
		SysDictItem.EntityNode n = SysDictItem.EntityNode.INSTANCE;
		SelectStatement<SysDictItem> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.dictId.eq(id));
		st.orderby().asc(n.orderNum).desc(n.id);
		return this.repo.selectByStatement(st);
	}

	@Override
	public List<SysDictItem> findByIds(List<Integer> ids) {
		SysDictItem.EntityNode n = SysDictItem.EntityNode.INSTANCE;
		SelectStatement<SysDictItem> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.id.in(ids));
		return this.repo.selectByStatement(st);
	}

}
