package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.integriti.center.biz.job.SimpleHttpExecutorJob;
import cn.integriti.center.biz.sys.dao.SysHttpJobMapper;
import cn.integriti.center.biz.sys.domain.SysHttpJob;
import cn.integriti.center.biz.sys.service.SchedulerService;
import cn.integriti.center.biz.sys.service.SysHttpJobService;
import cn.integriti.center.biz.sys.service.SysJobService;
import cn.integriti.center.biz.sys.service.SysJobTriggerService;
import cn.integriti.center.core.util.SchedulerUtil;

/**
 * SysHttpJobServiceImpl
 * 
 * @author generator
 * @date 2019年03月21日
 */
@Service
public class SysHttpJobServiceImpl implements SysHttpJobService {

	@Autowired
	private SysHttpJobMapper repo;

	@Autowired
	private SchedulerService schedulerService;

	private static final Logger logger = LoggerFactory.getLogger(SysHttpJobServiceImpl.class);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	@Transactional
	public void save(SysHttpJob entity) {
		entity.setOpOn(new Date());
		entity.setCreateOn(entity.getOpOn());
		// SchedulerUtil.checkJobClass(entity.getUrl());

		repo.insert(entity);

		//
		this.addTrigger(entity);
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	@Transactional
	public void update(SysHttpJob entity) {
		entity.setOpOn(new Date());
		// SchedulerUtil.checkJobClass(entity.getUrl());
		repo.update(entity);

		// 更新触发
		this.updateTrigger(entity);
	}

	/**
	 * 添加触发器
	 * 
	 * @param triggerVO
	 */
	public void addTrigger(SysHttpJob job) {

		try {
			JobDataMap jobData = new JobDataMap();
			jobData.put("url", job.getUrl());
			TriggerBuilder<CronTrigger> triggerBuilder = TriggerBuilder.newTrigger()
					.withIdentity(SchedulerUtil.getHttpTriggerKey(job))
					.withSchedule(CronScheduleBuilder.cronSchedule(job.getExpression())).usingJobData(jobData)
					.withPriority(5).withDescription(job.getRemark());
			JobDetail jobDetail = this.schedulerService.getJobDetail(SchedulerUtil.getHttpJobKey(job));
			if (jobDetail == null) {
				jobDetail = createNewJob(job);
				this.schedulerService.scheduleJob(jobDetail, triggerBuilder.build());
			} else {
				this.schedulerService.scheduleJob(triggerBuilder.forJob(jobDetail).build());
			}
		} catch (SchedulerException se) {
			throw new RuntimeException("新增解发器异常:" + se.getMessage(), se);
		}
	}

	private JobDetail createNewJob(SysHttpJob job) {
		Class<Job> jobClass = SchedulerUtil.getJobClass(SimpleHttpExecutorJob.class.getName());
		JobDetail detail = JobBuilder.newJob(jobClass).withIdentity(SchedulerUtil.getHttpJobKey(job))
				.withDescription(job.getRemark()).build();
		return detail;
	}

	public void updateTrigger(SysHttpJob job) {
		try {
			JobDetail jobDetail = this.schedulerService.getJobDetail(SchedulerUtil.getHttpJobKey(job));
			if (jobDetail == null) {
				
				jobDetail = this.createNewJob(job);
			}
			JobDataMap jobData = new JobDataMap();
			jobData.put("url", job.getUrl());

			TriggerKey oldTriggerKey = SchedulerUtil.getHttpTriggerKey(job);
			Trigger oldTrigger = this.schedulerService.getScheduler().getTrigger(oldTriggerKey);
			if (oldTrigger == null) {
				logger.warn("未查询到相关触发器[triggerName:{},job:{}]", oldTriggerKey.getName(), oldTriggerKey.getGroup());
				this.addTrigger(job);
			} else {
				TriggerKey triggerKey = SchedulerUtil.getHttpTriggerKey(job);
				Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).usingJobData(jobData)
						.withDescription(job.getRemark()).withPriority(5)
						.withSchedule(CronScheduleBuilder.cronSchedule(job.getExpression())).forJob(jobDetail).build();

				this.schedulerService.getScheduler().rescheduleJob(oldTriggerKey, newTrigger);
			}
		} catch (SchedulerException se) {
			throw new RuntimeException("更新解发器异常:" + se.getMessage(), se);
		}
	}

	/**
	 * 暂停任务
	 * 
	 * @param job
	 */
	public void pauseJob(SysHttpJob job) {

		try {
			this.schedulerService.pauseTrigger(SchedulerUtil.getHttpTriggerKey(job));
		} catch (SchedulerException e) {
			throw new RuntimeException("暂停触发器异常:" + e.getMessage(), e);
		}
	}

	/**
	 * 恢复任务
	 * 
	 * @param job
	 */
	public void resumeJob(SysHttpJob job) {
		try {
			this.schedulerService.resumeTrigger(SchedulerUtil.getHttpTriggerKey(job));
		} catch (SchedulerException e) {
			throw new RuntimeException("恢复触发器异常:" + e.getMessage(), e);
		}
	}

	/**
	 * 较验实体
	 * 
	 * @param entity
	 */
	public void checkEntity(SysHttpJob entity) {

	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk) {
		SysHttpJob job = this.findById(pk);
		
		try {
			this.schedulerService.deleteTrigger(SchedulerUtil.getHttpTriggerKey(job));
		} catch (SchedulerException e) {
			throw new RuntimeException("删除触发器异常:" + e.getMessage(), e);
		}
		repo.deleteByPK(pk);
		
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysHttpJob findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysHttpJob
	 * @return
	 */
	public List<SysHttpJob> findByNotNullProps(SysHttpJob entity) {

		SelectStatement<SysHttpJob> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysHttpJob
	 * @return
	 */
	public void updateNotNullPropsById(SysHttpJob entity) {

		UpdateStatement<SysHttpJob> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	/**
	 * 通过实体参数分页查询
	 * 
	 * @param SysHttpJob.QueryParam
	 * @return
	 */
	public List<SysHttpJob> findByQueryParam(SysHttpJob.QueryParam queryParam) {
		return repo.findByQueryParam(queryParam);
	}

	/**
	 * 通过实体参数统计
	 * 
	 * @param SysHttpJob.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysHttpJob.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}

	/**
	 * 通过ID集合查询
	 * 
	 * @param List<Integer> pks
	 * @return
	 */
	public List<SysHttpJob> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}

	/**
	 * 值填充
	 */
	public void fillValues(List<SysHttpJob> items, SysHttpJob.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}

	@Override
	public void pause(Integer id) {
		SysHttpJob tmp = this.findById(id);
		this.pauseJob(tmp);
		tmp.setStatus(2);
		
		repo.update(tmp);
	}

	@Override
	public void resume(Integer id) {
		SysHttpJob tmp = this.findById(id);
		this.resumeJob(tmp);
		tmp.setStatus(1);
		repo.update(tmp);
	}
}
