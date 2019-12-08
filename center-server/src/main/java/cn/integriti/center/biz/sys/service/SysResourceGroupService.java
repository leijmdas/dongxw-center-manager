package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.queryParam.SysResourceGroupQueryParam;
/**
 * SysResourceGroupService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysResourceGroupService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysResourceGroup entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysResourceGroup entity);
	
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
	public SysResourceGroup findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysResourceGroup
	 * @return
	 */
	public List<SysResourceGroup> findByNotNullProps(SysResourceGroup entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysResourceGroup
	 * @return
	 */
	public void updateNotNullPropsById(SysResourceGroup entity);
	
	/**
	 * 查询全部
	 * @param resType
	 * @return
	 */
	public List<SysResourceGroup> findAllByType(Integer domainId,Byte resType);

	public List<SysResourceGroup> findByQueryParam(SysResourceGroupQueryParam queryParam);

	public List<SysResourceGroup> findRoleResources(List<Integer> roleIds);

	/**
	 * 通过id列表查询
	 * @param ids
	 * @return
	 */
	public List<SysResourceGroup> findByIds(List<Integer> ids);
}
