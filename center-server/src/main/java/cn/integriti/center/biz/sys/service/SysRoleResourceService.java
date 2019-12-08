package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysRoleResource;
/**
 * SysRoleResourceService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysRoleResourceService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysRoleResource entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysRoleResource entity);
	
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
	public SysRoleResource findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysRoleResource
	 * @return
	 */
	public List<SysRoleResource> findByNotNullProps(SysRoleResource entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysRoleResource
	 * @return
	 */
	public void updateNotNullPropsById(SysRoleResource entity);
	
}
