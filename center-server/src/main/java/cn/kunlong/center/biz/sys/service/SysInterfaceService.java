package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysInterface;
import cn.kunlong.center.biz.sys.domain.SysJobTrigger;
import cn.kunlong.center.biz.sys.queryParam.SysInterfaceParam;

/**
 * SysInterfaceService
 * 
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceService {

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysInterface entity);

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysInterface entity);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk);

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysInterface findById(Integer pk);

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysInterface
	 * @return
	 */
	public List<SysInterface> findByNotNullProps(SysInterface entity);

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysInterface
	 * @return
	 */
	public void updateNotNullPropsById(SysInterface entity);

	public List<SysInterface> findByQueryParam(SysInterfaceParam queryParam);

	public long countByQueryParam(SysInterfaceParam queryParam);

	public List<SysJobTrigger> findTriggerByInterface(SysInterfaceParam queryParam);

	/**
	 * 分配触发器
	 * 
	 * @param id
	 * @param idList
	 */
	public void assignTriggers(Integer id, List<Integer> idList);

	public List<SysInterface> findByTriggerId(Integer triggerId, Byte... status);

	/**
	 * 调用接口
	 * 
	 * @param intf
	 */
	public void invokeService(SysInterface intf);
}
