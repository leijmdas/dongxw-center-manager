package cn.kunlong.center.biz.sys.service;


import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    
    @Autowired
    private  org.springframework.scheduling.quartz.SchedulerFactoryBean factory;

    public Scheduler getScheduler()  {
        return factory.getScheduler();
    }
    /**
     * 添加任务
     * @param detail
     * @param replace
     * @throws SchedulerException
     */
    public void addJob(JobDetail detail,boolean replace) throws SchedulerException{
        this.getScheduler().addJob(detail, replace);
    }
    /**
     * 删除任务
     * @param jobKey
     * @return
     * @throws SchedulerException
     */
    public boolean deleteJob(JobKey jobKey) throws SchedulerException{
        
        return this.getScheduler().deleteJob(jobKey);
    }
    /**
     * 获取quartz任务
     * @param jobKey
     * @return
     * @throws SchedulerException
     */
    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException{
    	
        return this.getScheduler().getJobDetail(jobKey);
    }
    /**
     * 是否存在
     * @param jobKey
     * @return
     * @throws SchedulerException
     */
    public boolean existJob(JobKey jobKey) throws SchedulerException{
        return this.getScheduler().checkExists(jobKey);
    }
    /**
     * 恢复任务
     * @param trigger
     * @return
     * @throws SchedulerException
     */
    public Date scheduleJob(Trigger trigger) throws SchedulerException{
        return this.getScheduler().scheduleJob(trigger);
    }
    /**
     * 删除触发器
     * @param triggerKey
     * @return
     * @throws SchedulerException
     */
    public boolean deleteTrigger(TriggerKey triggerKey) throws SchedulerException{
        return this.getScheduler().unscheduleJob(triggerKey);
    }
    /**
     * 暂停触发器
     * @param triggerKey
     * @throws SchedulerException
     */
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        this.getScheduler().pauseTrigger(triggerKey);
    }

    
    /**
     * 恢复触发器
     * @param triggerKey
     * @throws SchedulerException
     */
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        this.getScheduler().resumeTrigger(triggerKey);
    }
    
    /**
     * 暂停任务
     * @param jobKey
     * @throws SchedulerException
     */
    public void pauseJob(JobKey jobKey) throws SchedulerException{
        this.getScheduler().pauseJob(jobKey);
    }
    /**
     * 恢复任务
     * @param jobKey
     * @throws SchedulerException
     */
    public void resumeJob(JobKey jobKey) throws SchedulerException{
        this.getScheduler().resumeJob(jobKey);
    }
    /**
     * 暂停全部
     * @throws SchedulerException
     */
    public void pauseAll() throws SchedulerException{
        this.getScheduler().pauseAll();
    }
    /**
     * 恢复全部
     * @throws SchedulerException
     */
    public void resumeAll() throws SchedulerException{
        this.getScheduler().resumeAll();
    }
    
    public boolean isStarted() throws SchedulerException{
        return this.getScheduler().isStarted();
    }
    
    public void shutdown() throws SchedulerException{
        this.getScheduler().shutdown();
    }
    public void scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        this.getScheduler().scheduleJob(jobDetail, trigger);
    }
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        return this.getScheduler().getTrigger(triggerKey);
    }
} 


