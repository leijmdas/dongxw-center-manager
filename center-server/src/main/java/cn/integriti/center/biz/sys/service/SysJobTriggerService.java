package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysJobTrigger;
import cn.integriti.center.biz.sys.queryParam.SysJobTriggerParam;
/**
 * SysJobTriggerService
 * @author generator
 * @date 2016年06月01日
 */
public interface SysJobTriggerService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysJobTrigger entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysJobTrigger entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 *通过id获取
	 * @param id
	 * @return
	 */
	public SysJobTrigger findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysJobTrigger
	 * @return
	 */
	public List<SysJobTrigger> findByNotNullProps(SysJobTrigger entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysJobTrigger
	 * @return
	 */
	public void updateNotNullPropsById(SysJobTrigger entity);

	public List<SysJobTrigger> findByQueryParam(SysJobTriggerParam queryParam);
	
	public long countByQueryParam(SysJobTriggerParam queryParam);
	
	public SysJobTrigger findJobTriggerById(Integer id);
	
	public int updateClause(SysJobTrigger sysJobTrigger);

	public void pause(Integer id);
	
	public void resume(Integer id);

	public List<SysJobTrigger> findAllTriggers(Integer jobType);

	public List<SysJobTrigger> findTriggersByJobId(Integer jobId);
}
