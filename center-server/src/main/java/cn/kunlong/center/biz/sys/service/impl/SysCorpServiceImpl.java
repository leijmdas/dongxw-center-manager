package cn.kunlong.center.biz.sys.service.impl;

import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.sys.dao.SysCorpMapper;
import cn.kunlong.center.biz.sys.domain.SysCorp;
import cn.kunlong.center.biz.sys.service.SysCorpService;
/**
 * SysCorpServiceImpl
 * @author generator
 * @date 2018年06月07日
 */
@Service
public class SysCorpServiceImpl implements SysCorpService {
	
	@Autowired
	private SysCorpMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysCorp entity){
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysCorp entity){
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
	public SysCorp findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysCorp
	 * @return
	 */
	public List<SysCorp> findByNotNullProps(SysCorp entity){
		
		SelectStatement<SysCorp> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysCorp
	 * @return
	 */
	public void updateNotNullPropsById(SysCorp entity){
		
		UpdateStatement<SysCorp> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param SysCorp.QueryParam
	 * @return
	 */
	public List<SysCorp> findByQueryParam(SysCorp.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param SysCorp.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysCorp.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}

	@Override
	public SysCorp findByCode(String code) {
		SysCorp.EntityNode n = SysCorp.EntityNode.INSTANCE;
		SelectStatement<SysCorp> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.corpCode.eq(code));
		return this.repo.selectByStatement(st).stream().findFirst().orElse(null);
	}

	@Override
	public List<SysCorp> findMicroList(SysCorp.QueryParam qp) {
		SysCorp.EntityNode n = SysCorp.EntityNode.INSTANCE;
		SelectStatement<SysCorp> st = StatementBuilder.buildSelect(n);
		if (qp.getIds() != null && !qp.getIds().isEmpty()) {
			st.getRestrictions().add(n.id.in(qp.getIds()));
		} else {
			this.findByQueryParam(qp);
		}
		return repo.selectByStatement(st);
	}
	
}
