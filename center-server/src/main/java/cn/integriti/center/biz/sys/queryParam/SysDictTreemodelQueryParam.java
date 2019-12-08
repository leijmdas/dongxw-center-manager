package cn.integriti.center.biz.sys.queryParam;

import cn.integriti.center.biz.sys.domain.SysDictTreemodel;
import cn.integriti.center.core.support.query.QueryParam;

public class SysDictTreemodelQueryParam extends QueryParam<SysDictTreemodel> {

	private Boolean cascadeChild;
	private String code;
	
	public Boolean getCascadeChild() {
		return cascadeChild;
	}

	public void setCascadeChild(Boolean cascadeChild) {
		this.cascadeChild = cascadeChild;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
