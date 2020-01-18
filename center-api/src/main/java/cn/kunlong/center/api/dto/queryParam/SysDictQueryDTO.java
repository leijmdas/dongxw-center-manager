package cn.kunlong.center.api.dto.queryParam;

import java.io.Serializable;

import app.support.query.PageQueryParam;
import cn.kunlong.center.api.model.SysDictDTO;

public class SysDictQueryDTO extends PageQueryParam<SysDictDTO> implements Serializable{

	private static final long serialVersionUID = 1L;

	private String keywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
}
