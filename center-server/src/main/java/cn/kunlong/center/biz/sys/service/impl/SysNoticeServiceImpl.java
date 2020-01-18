package cn.kunlong.center.biz.sys.service.impl;

import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.sys.dao.SysNoticeMapper;
import cn.kunlong.center.biz.sys.domain.SysNotice;
import cn.kunlong.center.biz.sys.queryParam.SysNoticeQueryParam;
import cn.kunlong.center.biz.sys.service.SysNoticeService;
/**
 * SysNoticeServiceImpl
 * @author generator
 * @date 2015年12月17日
 */
@Service
public class SysNoticeServiceImpl implements SysNoticeService {
	
	@Autowired
	private SysNoticeMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysNotice entity){
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysNotice entity){
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
	public SysNotice findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysNotice
	 * @return
	 */
	public List<SysNotice> findByNotNullProps(SysNotice entity){
		
		SelectStatement<SysNotice> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysNotice
	 * @return
	 */
	public void updateNotNullPropsById(SysNotice entity){
		
		UpdateStatement<SysNotice> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysNotice> findByQueryParam(SysNoticeQueryParam queryParma) {
		SelectStatement<SysNotice> st = createStatement(queryParma);
		return this.repo.selectByStatement(st);
	}

	@Override
	public long countByQueryParam(SysNoticeQueryParam queryParam) {
		SelectStatement<SysNotice> st = createStatement(queryParam);
		return this.repo.countByRestrictions(st.getRestrictions());
	}

	@Override
	public List<SysNotice> findAll() {
		SysNotice.EntityNode n = SysNotice.EntityNode.INSTANCE;
		SelectStatement<SysNotice> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}
	
	private SelectStatement<SysNotice> createStatement(SysNoticeQueryParam queryParam) {
		SysNotice.EntityNode n = SysNotice.EntityNode.INSTANCE;

		SelectStatement<SysNotice> st = StatementBuilder.buildSelect(n);
		SysNotice p = queryParam.getParam();
		if (p != null) {
			if (p.getBeginDate() != null) {
				st.restrictions().add(n.beginDate.eq(p.getBeginDate()));
			}
			if (p.getEndDate() != null) {
				st.restrictions().add(n.endDate.eq(p.getEndDate()));
			}
			if (p.getTitile() != null&&p.getTitile().length()>0) {
				st.restrictions().add(n.titile.eq(p.getTitile()));
			}
//			if (StringUtils.isNotBlank(p.getRoleCode())) {
//				st.restrictions().add(n.roleCode.eq(p.getRoleCode()));
//			}
//			if (StringUtils.isNotBlank(p.getRoleName())) {
//				st.restrictions().add(n.roleName.like("%" + p.getRoleName() + "%"));
//			}

		}
		return st;
	}
}
