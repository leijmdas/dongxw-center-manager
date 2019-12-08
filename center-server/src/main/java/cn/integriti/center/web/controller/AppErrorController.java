package cn.integriti.center.web.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import cn.integriti.center.core.exception.BusinessException;


/**
 * 
 * @className: AppErrorController  
 * @description: 全局异常处理 
 * @author zz  | www.integriti.cn
 * @date 2018年4月20日  
 *
 */

@Controller
@RequestMapping(value = "/error")
public class AppErrorController implements ErrorController {

	private ErrorAttributes errorAttributes;

	@Autowired
	private ServerProperties serverProperties;

	/**
	 * 初始化ExceptionController
	 * 
	 * @param errorAttributes
	 */
	@Autowired
	public AppErrorController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	/**
	 * 定义404的ModelAndView
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(produces = "text/html", value = "404")
	public ModelAndView errorHtml404(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("error/404", model);
	}

	/**
	 * 定义404的JSON数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "404")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error404(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		HttpStatus status = getStatus(request);
		return new ResponseEntity<Map<String, Object>>(body, status);
	}

	/**
	 * 定义500的ModelAndView
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(produces = "text/html", value = "500")
	public ModelAndView errorHtml500(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("error/500", model);
	}

	/**
	 * 定义500的错误JSON信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "500")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error500(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		HttpStatus status = getStatus(request);
		return new ResponseEntity<Map<String, Object>>(body, status);
	}

	/**
	 * Determine if the stacktrace attribute should be included.
	 * 
	 * @param request
	 *            the source request
	 * @param produces
	 *            the media type produced (or {@code MediaType.ALL})
	 * @return if the stacktrace attribute should be included
	 */
	protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}

	/**
	 * 获取错误的信息
	 * 
	 * @param request
	 * @param includeStackTrace
	 * @return
	 */
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(request);
		return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
	}

	/**
	 * 是否包含trace
	 * 
	 * @param request
	 * @return
	 */
	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}

	/**
	 * 获取错误编码
	 * 
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	@RequestMapping(produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		response.setCharacterEncoding("UTF-8");
		return new ModelAndView("error", model);
	}
	/**
	 * 全局异常
	 * @param request
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(request);
		Map<String,Object> errorAttributes = this.getErrorAttributes(request, false);
		
		HttpStatus status = getStatus(request);

		Throwable exception = this.errorAttributes.getError(webRequest);
		
		Map<String, Object> data = new HashMap<String, Object>();
		Object path = errorAttributes.get("path");
		data.put("path", path);
		data.put("timestamp", new Date());

		Map<String, Object> tmp = getExceptionEntity(exception);
		data.putAll(tmp);
		
		HttpStatus statusTmp = getHttpStatus(exception);
		status = statusTmp == null?status:statusTmp;
		
		return new ResponseEntity<Map<String, Object>>(data, status);
	}
	private HttpStatus getHttpStatus(Throwable e ) {
		if (e != null) {
			if (e instanceof BusinessException) {
				return HttpStatus.BAD_REQUEST;
			}
		}
		return null;
	}
	private Map<String, Object> getExceptionEntity(Throwable e) {

		String code = "-1", msg = "";
		if (e != null) {
			if (e instanceof BusinessException) {
				BusinessException ex = (BusinessException) e;
				code = ex.getCode();
				msg = ex.getMessage();
			} else if(e instanceof HttpMessageNotReadableException) {
				code = "err_data_01";
				msg = "数据格式错误，请检查相关输入项！";
			} else {
				msg = e.getMessage();
			}
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", code);
		data.put("msg", msg);
		return data;
	}

	@Override
	public String getErrorPath() {
		return "";
	}
}
