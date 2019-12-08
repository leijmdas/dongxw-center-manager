package cn.integriti.center.biz.sys.queryParam;

import cn.integriti.center.biz.sys.domain.SysPosition;
import cn.integriti.center.core.support.query.QueryParam;

public class SysPositionQueryParam extends QueryParam<SysPosition> {
	/**
	 * 级联子
	 */
	private Boolean cascadeOrgChild;

	public Boolean getCascadeOrgChild() {
		return cascadeOrgChild;
	}

	public void setCascadeOrgChild(Boolean cascadeOrgChild) {
		this.cascadeOrgChild = cascadeOrgChild;
	}

}
