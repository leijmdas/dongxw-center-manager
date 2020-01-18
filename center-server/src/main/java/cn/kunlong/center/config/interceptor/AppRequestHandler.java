package cn.kunlong.center.config.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import app.support.context.DefaultRequestContextFactory;
import app.support.context.RequestContext;
import cn.kunlong.center.core.enums.RequestContextKeyEnum;

public class AppRequestHandler implements HandlerInterceptor {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		DefaultRequestContextFactory.getInstance().delete();
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse rsp, Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp, Object arg2) throws Exception {
		logger.info("接收请求[path:"+req.getRequestURI()+"]");
		
		RequestContext ctx = DefaultRequestContextFactory.getInstance().getRequestContext();
		if (ctx == null) {
			ctx = DefaultRequestContextFactory.getInstance().create();
		}
		ctx.setAttribute(RequestContextKeyEnum.CORP_ID.getValue(), req.getHeader("X-CorpId"));
		
		return true;
	}

}
