package cn.kunlong.center.biz.sys.queryParam;

import cn.kunlong.center.biz.sys.domain.SysDict;
import cn.kunlong.center.core.support.query.QueryParam;

public class SysDictQueryParam extends QueryParam<SysDict> {

	/**
	 * 关键值，支持code,name
	 */
	private String keywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
}
