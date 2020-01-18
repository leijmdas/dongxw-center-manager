package cn.kunlong.center.biz.job;

import java.util.List;

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
import cn.kunlong.center.biz.sys.domain.SysInterface;
import cn.kunlong.center.biz.sys.service.SysInterfaceService;
import cn.kunlong.center.core.enums.StatusEnum;
import cn.kunlong.center.core.util.SchedulerUtil;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HttpExecutorJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(HttpExecutorJob.class);

	@Override
	public void execute(JobExecutionContext executionCtx) throws JobExecutionException {

		String triggerId = executionCtx.getTrigger().getKey().getName();

		ApplicationContext ctx = null;
		try {
			ctx = SchedulerUtil.getApplicationContext(executionCtx);

		} catch (SchedulerException e) {
			throw new RuntimeException("获取Spring Context异常", e);
		}
		SysInterfaceService intfService = ctx.getBean(SysInterfaceService.class);
		List<SysInterface> intfList = intfService.findByTriggerId(Integer.parseInt(triggerId), StatusEnum.ENABLE.getValue());
		if (intfList != null) {
			logger.debug("接口数量:" + intfList.size());
			for (SysInterface intf : intfList) {
				try {
					intfService.invokeService(intf);
				} catch (Exception e) {
					logger.warn("调用接口异常[name:{},uri:{}]", new Object[]{intf.getIntfName(),intf.getRequestUrl()}, e);
					ctx.publishEvent(new JobExceptionEvent(new RuntimeException(String.format("调用接口异常[%s]", intf.getIntfName()), e)));
				}
			}
		}
	}

}
