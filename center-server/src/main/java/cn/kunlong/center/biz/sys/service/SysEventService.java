package cn.kunlong.center.biz.sys.service;

import cn.kunlong.center.biz.sys.domain.SysDomain;

public interface SysEventService {
	
	/**
	 * 告警
	 * @param domain
	 * @param level
	 * @param info
	 */
	void alert(SysDomain domain,Integer level,String subject,String info);
}
