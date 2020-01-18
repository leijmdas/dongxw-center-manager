package cn.kunlong.center.biz.sys.service.impl;

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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysJobMapper;
import cn.kunlong.center.biz.sys.dao.SysJobTriggerMapper;
import cn.kunlong.center.biz.sys.domain.SysJob;
import cn.kunlong.center.biz.sys.domain.SysJobTrigger;
import cn.kunlong.center.biz.sys.queryParam.SysJobTriggerParam;
import cn.kunlong.center.biz.sys.service.SchedulerService;
import cn.kunlong.center.biz.sys.service.SysJobTriggerService;
import cn.kunlong.center.core.util.SchedulerUtil;


/**
 * SysJobTriggerServiceImpl
 * 
 * @author generator
 * @date 2016年06月01日
 */
@Service
public class SysJobTriggerServiceImpl implements SysJobTriggerService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SysJobTriggerServiceImpl.class);
	
	@Autowired
	private SysJobTriggerMapper repo;

	@Autowired
	private SysJobMapper sysJobMapper;

	@Autowired
	private SchedulerService schedulerService;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	@Transactional
	public void save(SysJobTrigger entity) {
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		entity.setCreateBy(entity.getUpdateBy());
		entity.setCreateOn(entity.getUpdateOn());
		entity.setIsDeleted(false);
		repo.insert(entity);

		this.addTrigger(entity);
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysJobTrigger entity) {
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		repo.update(entity);

		this.updateTrigger(entity.getId().toString(), entity);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteById(Integer pk) {
		SysJobTrigger tmp = this.repo.selectByPK(pk);
		this.deleteTrigger(tmp.getId().toString(), tmp.getJobId());
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysJobTrigger findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysJobTrigger
	 * @return
	 */
	public List<SysJobTrigger> findByNotNullProps(SysJobTrigger entity) {

		SelectStatement<SysJobTrigger> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysJobTrigger
	 * @return
	 */
	public void updateNotNullPropsById(SysJobTrigger entity) {

		UpdateStatement<SysJobTrigger> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysJobTrigger> findByQueryParam(SysJobTriggerParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysJobTriggerParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public SysJobTrigger findJobTriggerById(Integer id) {
		return this.repo.findJobTriggerById(id);
	}

	@Transactional
	@Override
	public int updateClause(SysJobTrigger sysJobTrigger) {
		int row = this.repo.updateClause(sysJobTrigger);
		SysJobTrigger tmp = this.findById(sysJobTrigger.getId());
		this.updateTrigger(tmp.getId().toString(), tmp);
		return row;
	}

	/**
	 * 添加触发器
	 * 
	 * @param triggerVO
	 */
	public void addTrigger(SysJobTrigger triggerVO) {
		if (triggerVO.getJobId() == null) {
			throw new IllegalArgumentException("必须指定所属任务");
		}
		SysJob job = this.sysJobMapper.selectByPK(triggerVO.getJobId());

		try {
			JobDataMap jobData = new JobDataMap();
			if (triggerVO.getTriggerData() != null) {
				jobData.putAll(triggerVO.getTriggerData());
			}
			TriggerBuilder<CronTrigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity(SchedulerUtil.getTriggerKey(job, triggerVO.getId().toString())).withSchedule(CronScheduleBuilder.cronSchedule(triggerVO.getCronExpression())).usingJobData(jobData).withPriority(triggerVO.getPriority()).withDescription(triggerVO.getRemark());
			JobDetail jobDetail = this.schedulerService.getJobDetail(SchedulerUtil.getJobKey(job));
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

	/**
	 * 暂停触发器
	 * 
	 * @param triggerName
	 * @param jobId
	 */
	public void pauseTrigger(String triggerName, Integer jobId) {
		SysJob job = new SysJob();
		job.setId(jobId);
		try {
			this.schedulerService.pauseTrigger(SchedulerUtil.getTriggerKey(job, triggerName));
		} catch (SchedulerException e) {
			throw new RuntimeException("删除触发器异常:" + e.getMessage(), e);
		}
	}
	public void resumeTrigger(String triggerName, Integer jobId) {
		SysJob job = new SysJob();
		job.setId(jobId);
		try {
			this.schedulerService.resumeTrigger(SchedulerUtil.getTriggerKey(job, triggerName));
		} catch (SchedulerException e) {
			throw new RuntimeException("恢复触发器异常:" + e.getMessage(), e);
		}
	}

	/**
	 * 删除解发器
	 * 
	 * @param triggerName
	 * @param jobId
	 */
	public void deleteTrigger(String triggerName, Integer jobId) {
		SysJob job = new SysJob();
		job.setId(jobId);
		this.pauseTrigger(triggerName, jobId);
		try {
			this.schedulerService.deleteTrigger(SchedulerUtil.getTriggerKey(job, triggerName));
		} catch (SchedulerException e) {
			throw new RuntimeException("删除触发器异常:" + e.getMessage(), e);
		}
	}

	/**
	 * 更新触发器
	 * 
	 * @param triggerName
	 *            解发器名称
	 * @param triggerVO
	 */
	public void updateTrigger(String triggerName, SysJobTrigger triggerVO) {
		if (triggerVO.getJobId() == null) {
			throw new IllegalArgumentException("必须指定所属任务");
		}
		SysJob job = this.sysJobMapper.selectByPK(triggerVO.getJobId());
		try {
			JobDetail jobDetail = this.schedulerService.getJobDetail(SchedulerUtil.getJobKey(job));
			if (jobDetail == null) {
				throw new RuntimeException("不存在相关任务");
			}
			JobDataMap jobData = new JobDataMap();
			if (triggerVO.getTriggerData() != null) {
				jobData.putAll(triggerVO.getTriggerData());
			}
			
			
			TriggerKey oldTriggerKey = SchedulerUtil.getTriggerKey(job, triggerName);
			Trigger oldTrigger = this.schedulerService.getScheduler().getTrigger(oldTriggerKey);
			if (oldTrigger == null) {
				logger.warn("未查询到相关触发器[triggerName:{},job:{}]",triggerName,job.getJobName());
				this.addTrigger(triggerVO);
			} else {
				TriggerKey triggerKey = SchedulerUtil.getTriggerKey(job, triggerName);
				Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).usingJobData(jobData).withDescription(triggerVO.getRemark()).withPriority(triggerVO.getPriority()).withSchedule(CronScheduleBuilder.cronSchedule(triggerVO.getCronExpression())).forJob(jobDetail).build();

				this.schedulerService.getScheduler().rescheduleJob(oldTriggerKey, newTrigger);
			}
		} catch (SchedulerException se) {
			throw new RuntimeException("更新解发器异常:" + se.getMessage(), se);
		}
	}

	private JobDetail createNewJob(SysJob job) {
		Class<Job> jobClass = SchedulerUtil.getJobClass(job.getJobClass());
		JobDetail detail = JobBuilder.newJob(jobClass).withIdentity(SchedulerUtil.getJobKey(job)).withDescription(job.getRemark()).build();
		return detail;
	}

	@Override
	public void pause(Integer id) {
		SysJobTrigger tmp = this.findById(id);
		this.pauseTrigger(tmp.getId().toString(), tmp.getJobId());
		
	}

	@Override
	public void resume(Integer id) {
		SysJobTrigger tmp = this.findById(id);
		this.resumeTrigger(tmp.getId().toString(), tmp.getJobId());
	}

	@Override
	public List<SysJobTrigger> findAllTriggers(Integer jobType) {
		return this.repo.findAllTriggers(jobType);
	}

	@Override
	public List<SysJobTrigger> findTriggersByJobId(Integer jobId) {
		SysJobTrigger.EntityNode n = SysJobTrigger.EntityNode.INSTANCE;
		SelectStatement<SysJobTrigger> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.jobId.eq(jobId));
		return this.repo.selectByStatement(st);
	}

}
