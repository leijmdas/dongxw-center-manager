package cn.kunlong.center.web.core;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 全局异常
 * @author zz
 *
 */
public class GlobalWebExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalWebExceptionResolver.class);
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String msg = ex.getMessage();
		if( ValidationException.class.isAssignableFrom(ex.getClass())){ //较验性的简单记录
			LOGGER.info("business validation error.[contextPath:"+request.getContextPath()+",params:{"+request.getParameterMap()+"}]:"+ex.getMessage());
		} else if(DataIntegrityViolationException.class.isAssignableFrom(ex.getClass())){
			msg = "存在约束关系,请检查相关数据";
			LOGGER.error("request error.[sql exception:"+request.getContextPath()+",params:{"+request.getParameterMap()+"}]",ex);
		} else if(DataAccessException.class.isAssignableFrom(ex.getClass())){
			msg = "数据访问异常,请联系管理员";
			LOGGER.error("request error.[sql exception:"+request.getContextPath()+",params:{"+request.getParameterMap()+"}]",ex);
		} else if(SQLException.class.isAssignableFrom(ex.getClass()) ){
			msg = "数据库操作异常";
			LOGGER.error("request error.[sql exception:"+request.getContextPath()+",params:{"+request.getParameterMap()+"}]",ex);
		} else {
			msg = "系统异常:"+ex.getMessage();
			LOGGER.error("request error.[contextPath:"+request.getContextPath()+",params:{"+request.getParameterMap()+"}]",ex);
		}
		String xmlhttp = request.getHeader("X-Requested-With");
        if(xmlhttp == null || xmlhttp.trim().equals("")){ //非ajax
        
            return super.doResolveException(request, response, handler, ex);
        } else {
        	Map<String,Object> root = new HashMap<String,Object>();
        	root.put("msg", msg);

            root.put("code", -1);
            if( DataIntegrityViolationException.class.isAssignableFrom(ex.getClass())){
            	root.put("code", -21);
            } else if( SQLException.class.isAssignableFrom(ex.getClass())){ //数据访问
            	root.put("code", -20);
            }
            ObjectMapper mapper = new ObjectMapper();
            try {
            	String errorJson = mapper.writeValueAsString(root);
            	response.setStatus(400);
                response.setContentType("application/json;charset=UTF-8");
    			
    			response.getWriter().print(errorJson);
    			response.getWriter().close();
			} catch (IOException e) {
				LOGGER.error("write error json error:{}",e.getMessage());
			}
            return new ModelAndView();
        }
	}

	

}
