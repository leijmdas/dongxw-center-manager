package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysUserRole;
/**
 * SysUserRoleService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysUserRoleService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysUserRole entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysUserRole entity);
	
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
	public SysUserRole findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysUserRole
	 * @return
	 */
	public List<SysUserRole> findByNotNullProps(SysUserRole entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysUserRole
	 * @return
	 */
	public void updateNotNullPropsById(SysUserRole entity);

	public List<SysUserRole> findByQueryParam(SysUserRole.QueryParam queryParam);

	public SysUserRole findUnique(Integer userId, Integer roleId);
}
