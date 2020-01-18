package cn.kunlong.center.api.service;

import java.util.List;

import app.support.query.PageResult;
import cn.kunlong.center.api.dto.queryParam.SysOrgQueryDTO;
import cn.kunlong.center.api.model.SysOrgDTO;

public interface SysOrgApiService {

	/**
	 * 查询
	 * @param qp
	 * @return
	 */
	public PageResult<SysOrgDTO> query(SysOrgQueryDTO qp);
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public Integer save(SysOrgDTO entity);
	
	/**
	 * 按ID查询
	 * @param id
	 * @return
	 */
	public SysOrgDTO findById(Integer id);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 通过ID查询
	 * @param ids
	 * @return
	 */
	public List<SysOrgDTO> findByIds(List<Integer> ids);
	
	/**
	 * 企业组织树
	 * @param corpId
	 * @return
	 */
	public app.support.tree.TreeNode<SysOrgDTO> tree(Integer corpId);
}
