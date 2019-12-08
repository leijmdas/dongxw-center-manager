package cn.integriti.center.biz.sys.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import app.support.util.CollectionUtil;
import cn.integriti.center.biz.sys.domain.SysShortlink;
import cn.integriti.center.biz.support.validation.BeanValidator;
import cn.integriti.center.biz.sys.dao.SysShortlinkMapper;
import cn.integriti.center.biz.sys.service.SysShortlinkService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.core.exception.BusinessException;
import cn.integriti.center.core.util.SimpleSequenceGenerator;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SysShortlinkServiceImpl
 * @author generator
 * @date 2018年10月11日
 */
@Service
public class SysShortlinkServiceImpl implements SysShortlinkService {
	
	@Autowired
	private SysShortlinkMapper repo;
	
	@Value("${shortlink.app.url}")
	private String host ;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysShortlink entity){
		entity.setOpOn(new Date());
		entity.setCreateOn(entity.getOpOn());
		if(StringUtils.isEmpty(entity.getCode())) {
			entity.setCode(this.genCode());
		}
		entity.setShortUrl(host+"/"+entity.getCode());
		entity.setStatus(entity.getStatus() == null?StatusEnum.ENABLE.getValue():entity.getStatus());
		this.checkEntity(entity);
		repo.insert(entity);
	}

	private String genCode() {
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		return (Integer.toString(day, 31)+SimpleSequenceGenerator.getRandomSeq()).toUpperCase();
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysShortlink entity){
		entity.setOpOn(new Date());
		if(StringUtils.isEmpty(entity.getCode())) {
			entity.setCode(this.genCode());
		}
		entity.setShortUrl(host+"/"+entity.getCode());
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(SysShortlink entity){
		
		BeanValidator.propertyCheck(entity);
		SysShortlink tmp = this.findByCode(entity.getCode());
		if(tmp!=null && !tmp.getId().equals(entity.getId())) {
			throw new BusinessException("编码已存在");
		}
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
	public SysShortlink findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysShortlinkController
	 * @return
	 */
	public List<SysShortlink> findByNotNullProps(SysShortlink entity){
		
		SelectStatement<SysShortlink> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysShortlinkController
	 * @return
	 */
	public void updateNotNullPropsById(SysShortlink entity){
		
		UpdateStatement<SysShortlink> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param SysShortlink.QueryParam
	 * @return
	 */
	public List<SysShortlink> findByQueryParam(SysShortlink.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param SysShortlink.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysShortlink.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}

	@Override
	public SysShortlink findByCode(String code) {
		SysShortlink.EntityNode n = SysShortlink.EntityNode.INSTANCE;
		SelectStatement<SysShortlink> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.code.eq(code));
		return CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
	}
	
}
