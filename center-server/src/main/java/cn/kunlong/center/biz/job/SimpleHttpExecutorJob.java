package cn.kunlong.center.biz.job;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import cn.kunlong.center.biz.listener.JobExceptionEvent;
import cn.kunlong.center.core.util.SchedulerUtil;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SimpleHttpExecutorJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(SimpleHttpExecutorJob.class);

	@Override
	public void execute(JobExecutionContext executionCtx) throws JobExecutionException {

		String triggerId = executionCtx.getTrigger().getKey().getName();

		ApplicationContext ctx = null;
		try {
			ctx = SchedulerUtil.getApplicationContext(executionCtx);

		} catch (SchedulerException e) {
			throw new RuntimeException("获取Spring Context异常", e);
		}
		org.quartz.JobDataMap dataMap = executionCtx.getMergedJobDataMap();
		String url = dataMap.getString("url");
		logger.info("[开始请求]triggerId:{},url:{}",triggerId,url);
		long startTime = System.currentTimeMillis();
		if(StringUtils.isNoneBlank(url)) {
			try {
				invokeHttpRequest(url,ctx);
			} catch (Exception e) {
				logger.warn("调用接口异常[triggerId:{},uri:{}]", new Object[]{triggerId,url}, e);
				ctx.publishEvent(new JobExceptionEvent(triggerId,new RuntimeException(String.format("调用接口异常[%s]", url), e)));
			}
		}
		logger.info("[结束请求][triggerId:{},url:{}].cost:{} ms",new Object[] {triggerId,url,System.currentTimeMillis() - startTime});
		
	}

	private void invokeHttpRequest(String url,ApplicationContext applicationContext) {
		JerseyClient client = JerseyClientBuilder.createClient();
		client.property(ClientProperties.CONNECT_TIMEOUT, 10000);

		JerseyWebTarget target = client.target(url);
		Response rsp;		
		rsp = target.request().get();
		if (rsp.getStatus() != 200) {
			
			String readEntity = (String)(rsp.getEntity());
			logger.warn("调用接口异常[url:{}, StatusCode:{}].----响应 -----\n", url, rsp.getStatus(), readEntity);
			String msg = String.format("调用接口异常[名称:%s, StatusCode:%s].----响应 -----\n%s", url, rsp.getStatus(), readEntity);
			throw new RuntimeException(msg);
		}
		client.close();
	}

}
