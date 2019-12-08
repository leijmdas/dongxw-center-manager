package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysOrg;
import cn.integriti.center.core.support.tree.TreeNode;
/**
 * SysOrgService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysOrgService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysOrg entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysOrg entity);
	
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
	public SysOrg findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysOrg
	 * @return
	 */
	public List<SysOrg> findByNotNullProps(SysOrg entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysOrg
	 * @return
	 */
	public void updateNotNullPropsById(SysOrg entity);
	
	public List<SysOrg> findAllAvaliable();
	/**
	 * 获取组织机构根目录
	 * 
	 * @return
	 */
	public TreeNode<SysOrg> getRootNode(Integer corpId);
	TreeNode<SysOrg> buildTreeNode(List<SysOrg> depts);
	/**
	 * 通过实体参数查询
	 * @param queryParam
	 * @return
	 */
	public List<SysOrg> findByQueryParam(SysOrg.QueryParam queryParam);

	public long countByQueryParam(SysOrg.QueryParam queryParam);
	
	/**
	 * 导入组织结构 (格式：a/a1/a11或者a|a1|a11)
	 * @param items
	 * @return 错误信息：index0:记录值,index1:错误原因
	 */
	public List<String[]> importOrgs(List<String> items);

	public SysOrg findOrSaveDeptPath(String string);
	public List<SysOrg> findMicroList(SysOrg.QueryParam qp);

	/**
	 * 通过ID查询
	 * @param orgIds
	 * @return
	 */
	public List<SysOrg> findByIds(List<Integer> orgIds);
}
