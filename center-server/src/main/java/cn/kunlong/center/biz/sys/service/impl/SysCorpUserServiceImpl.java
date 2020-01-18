package cn.kunlong.center.biz.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.kunlong.center.biz.sys.domain.SysCorpUser;
import cn.kunlong.center.biz.sys.dao.SysCorpUserMapper;
import cn.kunlong.center.biz.sys.service.SysCorpUserService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SysCorpUserServiceImpl
 * @author generator
 * @date 2018年06月07日
 */
@Service
public class SysCorpUserServiceImpl implements SysCorpUserService {
	
	@Autowired
	private SysCorpUserMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysCorpUser entity){
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysCorpUser entity){
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
	public SysCorpUser findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysCorpUser
	 * @return
	 */
	public List<SysCorpUser> findByNotNullProps(SysCorpUser entity){
		
		SelectStatement<SysCorpUser> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysCorpUser
	 * @return
	 */
	public void updateNotNullPropsById(SysCorpUser entity){
		
		UpdateStatement<SysCorpUser> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param SysCorpUser.QueryParam
	 * @return
	 */
	public List<SysCorpUser> findByQueryParam(SysCorpUser.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param SysCorpUser.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysCorpUser.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	
}
