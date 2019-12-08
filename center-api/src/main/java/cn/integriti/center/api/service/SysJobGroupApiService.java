package cn.integriti.center.api.service;

import java.util.List;

import app.support.query.PageResult;
import cn.integriti.center.api.dto.queryParam.SysJobGroupQueryDTO;
import cn.integriti.center.api.model.SysJobGroupDTO;

/**
 * 
 * @name SysJobGroupApiService
 * 
 * @date 2019年03月23日  
 * @description:
 */
public interface SysJobGroupApiService {

	/**
	 * 查询
	 * @param qp
	 * @return
	 */
	public PageResult<SysJobGroupDTO> query(SysJobGroupQueryDTO qp);
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public Integer save(SysJobGroupDTO entity);
	
	/**
	 * 按ID查询
	 * @param id
	 * @return
	 */
	public SysJobGroupDTO findById(Integer id);
	
	/**
	 * 删除
	 * @param id
	 */
	boolean delete(Integer id);
	/**
	 * 修改
	 * @param entity
	 * @return 
	 */
     Integer update(SysJobGroupDTO entity);
	
	/**
	 * 通过ID查询
	 * @param ids
	 * @return
	 */
	public List<SysJobGroupDTO> findByIds(List<Integer> ids);

	//public List<Integer> findResourceIds(Integer id);

	//public void assignRoleResources(Integer id, List<Integer> resIds);
	
}
