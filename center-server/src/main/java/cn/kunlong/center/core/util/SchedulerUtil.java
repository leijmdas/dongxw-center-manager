package cn.kunlong.center.core.util;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.context.ApplicationContext;

import cn.kunlong.center.biz.sys.domain.SysHttpJob;
import cn.kunlong.center.biz.sys.domain.SysJob;
import cn.kunlong.center.biz.sys.domain.SysJobTrigger;

public class SchedulerUtil {
    
    public static final String GROUP_JOB = "scheduler";

    public static final String applicationContextKey = "applicationContext";
	/**
	 * 获取spring上下文
	 * @param ctx
	 * @return
	 * @throws SchedulerException
	 */
	public static ApplicationContext getApplicationContext(JobExecutionContext ctx) throws SchedulerException{
		//获取Spring中的上下文    
		ApplicationContext appCtx = (ApplicationContext)getSchedulerContext(ctx).get(applicationContextKey); 
		return appCtx;
	}
	public static SchedulerContext getSchedulerContext(JobExecutionContext ctx) throws SchedulerException{
		return ctx.getScheduler().getContext(); 
	}
	
	public static String getString(JobDataMap dataMap, String key, String defaultVal) {
		Object obj = dataMap.get(key);
    	if(obj == null) return defaultVal;
    	String i = dataMap.getString(key);
    	if(i == null) return defaultVal;
    	return i;
	}
    public static Integer getInteger(JobDataMap dataMap,String key,Integer defaultVal){
    	Object obj = dataMap.get(key);
    	if(obj == null) return defaultVal;
    	Integer i = dataMap.getIntegerFromString(key);
    	if(i == null) return defaultVal;
    	return i;
    }
    public static Boolean getBoolean(JobDataMap dataMap,String key,Boolean defaultVal){
    	Object obj = dataMap.get(key);
    	if(obj == null) return defaultVal;
    	Boolean i = dataMap.getBooleanFromString(key);
    	if(i == null) return defaultVal;
    	return i;
    }
    /**
     * 获取JobKey
     * @param job
     * @return
     */
    public static JobKey getJobKey(SysJob job){
        JobKey key = new JobKey(job.getId().toString(),GROUP_JOB);
        return key;
    }
    public static JobKey getHttpJobKey(SysHttpJob job){
        JobKey key = new JobKey("http_"+job.getId().toString(),GROUP_JOB);
        return key;
    }
    /**
     * 获取TriggerKey
     * @param job
     * @param triggerName
     * @return
     */
    public static TriggerKey getTriggerKey(SysJob job,String triggerName){
        TriggerKey key = new TriggerKey(triggerName,job.getId().toString());
        return key;
    }
    public static TriggerKey getHttpTriggerKey(SysHttpJob job){
        TriggerKey key = new TriggerKey(job.getId().toString(),job.getId().toString());
        return key;
    }
    public static String  getTriggerName(SysJobTrigger trigger){
        return trigger.getId().toString();
    }
    /**
     * 较验Jobclass
     * @param className
     */
    public static void checkJobClass(String className){
        getJobClass(className);
    }
    
    @SuppressWarnings("unchecked")
    public static Class<Job> getJobClass(String className){
        if(className == null || className.equals("")){
            throw new IllegalArgumentException("JobClass不能为空");
        }
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到指定类:" + className);
        }
        if (!Job.class.isAssignableFrom(clazz)) {
            throw new RuntimeException("Job类必须实现接口org.quartz.Job.class");
        }
        return (Class<Job>)clazz;
    }
}
