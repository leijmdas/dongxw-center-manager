package cn.integriti.center.api.service;

import java.util.List;

import app.support.query.PageResult;
import cn.integriti.center.api.dto.queryParam.SysResourceQueryDTO;
import cn.integriti.center.api.model.SysResourceDTO;
import cn.integriti.center.api.model.SysResourceGroupDTO;

public interface SysResourceApiService {
	/**
	 * 查询
	 * @param qp
	 * @return
	 */
	public PageResult<SysResourceDTO> query(SysResourceQueryDTO qp);
	/**
	 * 查询资源
	 * @return
	 */
	List<SysResourceGroupDTO> findAllResources();
}
