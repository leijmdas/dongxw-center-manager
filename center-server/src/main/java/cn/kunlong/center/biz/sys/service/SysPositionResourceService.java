package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysPositionResource;
/**
 * SysPositionResourceService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysPositionResourceService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysPositionResource entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysPositionResource entity);
	
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
	public SysPositionResource findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysPositionResource
	 * @return
	 */
	public List<SysPositionResource> findByNotNullProps(SysPositionResource entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysPositionResource
	 * @return
	 */
	public void updateNotNullPropsById(SysPositionResource entity);
	
}
