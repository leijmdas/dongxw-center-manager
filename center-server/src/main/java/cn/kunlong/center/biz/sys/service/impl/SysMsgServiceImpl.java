package cn.kunlong.center.biz.sys.service.impl;

import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.sys.dao.SysMsgMapper;
import cn.kunlong.center.biz.sys.domain.SysMsg;
import cn.kunlong.center.biz.sys.queryParam.SysMsgQueryParam;
import cn.kunlong.center.biz.sys.service.SysMsgService;
/**
 * SysMsgServiceImpl
 * @author generator
 * @date 2016年02月18日
 */
@Service
public class SysMsgServiceImpl implements SysMsgService {
	
	@Autowired
	private SysMsgMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysMsg entity){
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysMsg entity){
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
	public SysMsg findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysMsg
	 * @return
	 */
	public List<SysMsg> findByNotNullProps(SysMsg entity){
		
		SelectStatement<SysMsg> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysMsg
	 * @return
	 */
	public void updateNotNullPropsById(SysMsg entity){
		
		UpdateStatement<SysMsg> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	private SelectStatement<SysMsg> createStatementByQueryParam(SysMsgQueryParam queryParam) {
		SysMsg.EntityNode n = SysMsg.EntityNode.INSTANCE;
		SelectStatement<SysMsg> st = StatementBuilder.buildSelect(n);
		SysMsg m = queryParam.getParam();
		if(m.getReceiverId()!=null){
			st.restrictions().add(n.receiverId.eq(m.getReceiverId()));
		}
		return st;
	}
	@Override
	public List<SysMsg> findByQueryParam(SysMsgQueryParam queryParam) {
		SelectStatement<SysMsg> st = createStatementByQueryParam(queryParam);
		return this.repo.selectByStatement(st);
	}

	@Override
	public long countByQueryParam(SysMsgQueryParam queryParam) {
		SelectStatement<SysMsg> st = createStatementByQueryParam(queryParam);
		return this.repo.countByRestrictions(st.restrictions());
	}

	@Override
	public int countUnRead(Integer userId) {
		SysMsg.EntityNode n = SysMsg.EntityNode.INSTANCE;
		SelectStatement<SysMsg> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.receiverId.eq(userId)).add(n.isRead.eq(false));
		return this.repo.countByRestrictions(st.restrictions());
		
	}
}
