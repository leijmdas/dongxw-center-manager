package cn.kunlong.center.biz.sys.queryParam;

import cn.kunlong.center.biz.sys.domain.SysUser;
import cn.kunlong.center.core.support.query.QueryParam;

public class SysUserQueryParam extends QueryParam<SysUser> {
	
	/**
	 * 关联下级组织
	 */
	private Boolean cascadeOrgChild;
	
	/**
	 * 登陆名、姓名、电话或邮箱
	 */
	private String keyword;

	public Boolean getCascadeOrgChild() {
		return cascadeOrgChild;
	}

	public void setCascadeOrgChild(Boolean cascadeOrgChild) {
		this.cascadeOrgChild = cascadeOrgChild;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
