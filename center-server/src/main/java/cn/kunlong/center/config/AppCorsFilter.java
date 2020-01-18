package cn.kunlong.center.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppCorsFilter extends OncePerRequestFilter {

	protected final Log logger = LogFactory.getLog(getClass());

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		logger.debug("entering page");  
		// CORS "pre-flight" request
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "1800");// 30 min
		if(request.getMethod().toUpperCase().equals("OPTIONS")){
			
			return ;
		}
		filterChain.doFilter(request, response);
	}
}
