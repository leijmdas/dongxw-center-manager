package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysJob;
import cn.kunlong.center.biz.sys.queryParam.SysJobParam;
/**
 * SysJobService
 * @author generator
 * @date 2016年06月01日
 */
public interface SysJobService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysJob entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysJob entity);
	
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
	public SysJob findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysJob
	 * @return
	 */
	public List<SysJob> findByNotNullProps(SysJob entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysJob
	 * @return
	 */
	public void updateNotNullPropsById(SysJob entity);
	
	public List<SysJob> findByQueryParam(SysJobParam queryParam);
	public long countByQueryParam(SysJobParam queryParam);
	public int updateClause(SysJob sysJob);
	
	public List<SysJob> findAll();

	public SysJob findByGroupIdAndJobClass(Integer groupId, String jobClass);
}
