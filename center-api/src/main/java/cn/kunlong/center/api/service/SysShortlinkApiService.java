package cn.kunlong.center.api.service;

import app.support.query.PageResult;
import cn.kunlong.center.api.dto.queryParam.SysShortlinkQueryDTO;
import cn.kunlong.center.api.model.SysShortlinkDTO;

public interface SysShortlinkApiService {

	public PageResult<SysShortlinkDTO> query(SysShortlinkQueryDTO qp);
	
	public Integer save(SysShortlinkDTO entity);
	
	public SysShortlinkDTO findById(Integer userId);
	
	public void delete(Integer id);
	
	public SysShortlinkDTO findByCode(String code);

}
