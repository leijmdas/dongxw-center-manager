package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysResource;
import cn.kunlong.center.biz.sys.domain.SysResourceGroup;
/**
 * SysResourceService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysResourceService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysResource entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysResource entity);
	
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
	public SysResource findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysResource
	 * @return
	 */
	public List<SysResource> findByNotNullProps(SysResource entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysResource
	 * @return
	 */
	public void updateNotNullPropsById(SysResource entity);

	public List<SysResource> findByQueryParam(SysResource.QueryParam queryParam);

	public long countByQueryParam(SysResource.QueryParam queryParam);

	/**
	 * 查询资源分组与资源
	 * @return
	 */
	public List<SysResourceGroup> queryGroupAndResources();

	/**
	 * 通过ids查询带资源分组的资源
	 * @param ids
	 * @return
	 */
	public List<SysResource> findByIdsWithGroup(List<Integer> ids);

	public List<SysResource> findMicroList(SysResource.QueryParam qp);
}
