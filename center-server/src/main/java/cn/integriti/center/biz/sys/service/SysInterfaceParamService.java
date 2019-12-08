package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysInterfaceParam;
/**
 * SysInterfaceParamService
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceParamService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysInterfaceParam entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysInterfaceParam entity);
	
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
	public SysInterfaceParam findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysInterfaceParam
	 * @return
	 */
	public List<SysInterfaceParam> findByNotNullProps(SysInterfaceParam entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysInterfaceParam
	 * @return
	 */
	public void updateNotNullPropsById(SysInterfaceParam entity);

	public void flushInterfaceParams(Integer intifId, List<SysInterfaceParam> sysInterfaceParams);

	public List<SysInterfaceParam> findByInterfaceId(Integer interfaceId);
}
