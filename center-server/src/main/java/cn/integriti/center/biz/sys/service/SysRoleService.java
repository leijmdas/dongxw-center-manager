package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.domain.SysRole;
/**
 * SysRoleService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysRoleService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysRole entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysRole entity);
	
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
	public SysRole findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysRole
	 * @return
	 */
	public List<SysRole> findByNotNullProps(SysRole entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysRole
	 * @return
	 */
	public void updateNotNullPropsById(SysRole entity);

	/**
	 * 通过角色查询资源ids
	 * @param roleId
	 * @return
	 */
	public List<Integer> findResourceIds(Integer roleId);
	
	/**
	 * 分配角色资源
	 * @param roleId
	 * @param resIds
	 */
	public void assignRoleResources(Integer roleId,List<Integer> resIds);
	/**
	 * 查询角色资源
	 * @param roleId
	 * @return
	 */
	public List<SysResourceGroup> findRoleResources(List<Integer> roleIds);
	
	public List<SysResource> findRoleResources(Integer roleId);
	/**
	 * 查询用户角色
	 * @param userId
	 * @param type 
	 * @return
	 */
	public List<SysRole> findUserRoles(Integer userId, Integer type);
	

	public List<SysRole> findByQueryParam(SysRole.QueryParam queryParma);
	
	public long countByQueryParam(SysRole.QueryParam queryParma);

	public List<SysRole> findAll();
	public List<SysRole> findMicroList(SysRole.QueryParam qp);

	public List<SysRole> findByIds(List<Integer> ids);

}
