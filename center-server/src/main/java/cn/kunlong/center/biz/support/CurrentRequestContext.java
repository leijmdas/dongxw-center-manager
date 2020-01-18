package cn.kunlong.center.biz.support;

import app.support.context.DefaultRequestContextFactory;
import app.support.context.RequestContext;
import cn.kunlong.center.core.enums.RequestContextKeyEnum;

public class CurrentRequestContext {

	private CurrentRequestContext() {

	}

	/**
	 * @return 当前请求上下文
	 */
	public static RequestContext getContext() {
		return DefaultRequestContextFactory.getInstance().getRequestContext();
	}

	/**
	 * 当前用户
	 * 
	 * @return
	 */
	public static Integer getOpBy() {
		RequestContext ctx = getContext();
		if (ctx == null) return -1;
		Object obj = ctx.getAttribute("log.opBy");
		if (obj == null) {
			return null;
		}
		return (Integer) obj;
	}
	
	public static Integer getCurrentCorpId() {
		RequestContext ctx = getContext();
		if (ctx == null) return -1;
		Object obj = ctx.getAttribute(RequestContextKeyEnum.CORP_ID.getValue());
		if (obj == null) {
			return null;
		}
		return Integer.parseInt(obj.toString());
	}
}
