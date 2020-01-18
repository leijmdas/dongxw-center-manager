package cn.kunlong.center.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import app.support.exception.AppException;
import cn.kunlong.center.core.exception.BusinessException;

public class DubboRequestFilter implements com.alibaba.dubbo.rpc.Filter {

	private static final Logger logger = LoggerFactory.getLogger(DubboRequestFilter.class);
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		long startTime = System.currentTimeMillis();
		logger.debug("[开始]服务[id:{},url:{}]",startTime,invoker.getUrl());
		try {
			Result r =  invoker.invoke(invocation);
			
			
			return r;
		} finally {
			logger.debug("[结束]服务{}.耗时:{} ms",startTime,System.currentTimeMillis() - startTime);
		}
		
	}

	private RpcException wrapException(Result r) {
		Throwable ex = r.getException();
		if(ex == null) {
			return (RpcException)r;
		}
		logger.error("服务异常",ex);
		//统一异常
		
		AppException apiEx = null;
		if(ex instanceof AppException) {
			apiEx = (AppException)ex;
		} else if(ex instanceof BusinessException) {
			BusinessException bex = (BusinessException)ex;
			apiEx = new AppException(bex.getCode(),bex.getMessage(),bex.getCause());
		} else if(DataIntegrityViolationException.class.isAssignableFrom(ex.getClass())) {
			apiEx = new AppException("-11","存在数据约束关系",ex);
		} else if(DataAccessException.class.isAssignableFrom(ex.getClass())){
			apiEx = new AppException("-10","数据访问异常",ex);
		} else {
			apiEx = new AppException("0",ex.getMessage(),ex);
		}
		RpcException rpcException = new RpcException(RpcException.BIZ_EXCEPTION,ex.getMessage(),apiEx);
//		RpcResult rpcResult = new RpcResult();
//		rpcResult.setException(rpcException);
		return rpcException;
	}

}
