package cn.integriti.center.api.service;

import app.support.query.PageResult;
import cn.integriti.center.api.dto.queryParam.SysShortlinkQueryDTO;
import cn.integriti.center.api.model.SysShortlinkDTO;

public interface SysShortlinkApiService {

	public PageResult<SysShortlinkDTO> query(SysShortlinkQueryDTO qp);
	
	public Integer save(SysShortlinkDTO entity);
	
	public SysShortlinkDTO findById(Integer userId);
	
	public void delete(Integer id);
	
	public SysShortlinkDTO findByCode(String code);

}
