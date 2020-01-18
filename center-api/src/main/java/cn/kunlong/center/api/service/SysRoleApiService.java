package cn.kunlong.center.api.service;

import java.util.List;

import app.support.query.PageResult;
import cn.kunlong.center.api.dto.queryParam.SysRoleQueryDTO;
import cn.kunlong.center.api.model.SysRoleDTO;
/**
 * 角色服务
 * @name SysRoleApiService
 * @author zz  | zz@kunlong.cn
 * @date 2018年12月17日  
 * @description:
 */
public interface SysRoleApiService {

	/**
	 * 查询
	 * @param qp
	 * @return
	 */
	public PageResult<SysRoleDTO> query(SysRoleQueryDTO qp);
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public Integer save(SysRoleDTO entity);
	
	/**
	 * 按ID查询
	 * @param id
	 * @return
	 */
	public SysRoleDTO findById(Integer id);
	
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
	public List<SysRoleDTO> findByIds(List<Integer> ids);

	public List<Integer> findResourceIds(Integer id);

	public void assignRoleResources(Integer id, List<Integer> resIds);
	
}
