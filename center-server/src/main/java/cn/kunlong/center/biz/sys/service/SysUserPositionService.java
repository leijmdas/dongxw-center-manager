package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysUserPosition;
/**
 * SysUserRoleService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysUserPositionService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysUserPosition entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysUserPosition entity);
	
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
	public SysUserPosition findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysUserPosition
	 * @return
	 */
	public List<SysUserPosition> findByNotNullProps(SysUserPosition entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysUserPosition
	 * @return
	 */
	public void updateNotNullPropsById(SysUserPosition entity);
}
