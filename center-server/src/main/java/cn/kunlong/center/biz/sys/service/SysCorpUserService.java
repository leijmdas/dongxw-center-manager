package cn.kunlong.center.biz.sys.service;

import cn.kunlong.center.biz.sys.domain.SysCorpUser;
import java.util.List;
/**
 * SysCorpUserService
 * @author generator
 * @date 2018年06月07日
 */
public interface SysCorpUserService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysCorpUser entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysCorpUser entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysCorpUser findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysCorpUser
	 * @return
	 */
	public List<SysCorpUser> findByNotNullProps(SysCorpUser entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysCorpUser
	 * @return
	 */
	public void updateNotNullPropsById(SysCorpUser entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SysCorpUser.QueryParam
	 * @return
	 */
	public List<SysCorpUser> findByQueryParam(SysCorpUser.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SysCorpUser.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysCorpUser.QueryParam queryParam);
}
