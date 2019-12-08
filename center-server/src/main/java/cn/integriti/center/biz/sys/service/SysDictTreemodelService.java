package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysDictTreemodel;
import cn.integriti.center.biz.sys.queryParam.SysDictTreemodelQueryParam;
import cn.integriti.center.core.support.tree.TreeNode;
/**
 * SysDictTreemodelService
 * @author generator
 * @date 2015年12月27日
 */
public interface SysDictTreemodelService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDictTreemodel entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDictTreemodel entity);
	
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
	public SysDictTreemodel findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysDictTreemodel
	 * @return
	 */
	public List<SysDictTreemodel> findByNotNullProps(SysDictTreemodel entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysDictTreemodel
	 * @return
	 */
	public void updateNotNullPropsById(SysDictTreemodel entity);

	public List<SysDictTreemodel> findByQueryParam(
			SysDictTreemodelQueryParam queryParam);

	public long countByQueryParam(SysDictTreemodelQueryParam queryParam);

	public List<SysDictTreemodel> findAllAvaliable(String code);

	public TreeNode<SysDictTreemodel> buildTreeNode(List<SysDictTreemodel> locations);

	public List<SysDictTreemodel> findByIds(List<Integer> ids);
	
	public String getDisplayText(String ids);
}
