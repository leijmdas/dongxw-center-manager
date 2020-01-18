package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysInterfaceTrigger;
/**
 * SysInterfaceTriggerService
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceTriggerService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysInterfaceTrigger entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysInterfaceTrigger entity);
	
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
	public SysInterfaceTrigger findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysInterfaceTrigger
	 * @return
	 */
	public List<SysInterfaceTrigger> findByNotNullProps(SysInterfaceTrigger entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysInterfaceTrigger
	 * @return
	 */
	public void updateNotNullPropsById(SysInterfaceTrigger entity);
	public long deleteTriggerIdInterfaceId(SysInterfaceTrigger entity);

	public List<SysInterfaceTrigger> findByInterfaceId(Integer id);
}
