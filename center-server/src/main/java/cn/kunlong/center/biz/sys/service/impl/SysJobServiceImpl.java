package cn.kunlong.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysJobMapper;
import cn.kunlong.center.biz.sys.domain.SysJob;
import cn.kunlong.center.biz.sys.queryParam.SysJobParam;
import cn.kunlong.center.biz.sys.service.SchedulerService;
import cn.kunlong.center.biz.sys.service.SysJobService;
import cn.kunlong.center.core.util.SchedulerUtil;
/**
 * SysJobServiceImpl
 * @author generator
 * @date 2016年06月01日
 */
@Service
public class SysJobServiceImpl implements SysJobService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysJobServiceImpl.class);
	
	@Autowired
	private SysJobMapper repo;
	
	@Autowired
	private SchedulerService schedulerSevice;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysJob entity){
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		entity.setCreateBy(entity.getUpdateBy());
		entity.setCreateOn(entity.getUpdateOn());
		SchedulerUtil.checkJobClass(entity.getJobClass());
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysJob entity){
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		SchedulerUtil.checkJobClass(entity.getJobClass());
		repo.update(entity);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
		SysJob job = this.findById(pk);
        if (job == null) {
            return ;
        }
        try {
            if (this.schedulerSevice.existJob(SchedulerUtil.getJobKey(job))) {
                boolean flag = false;
                logger.debug("删除Job.id:{}", job.getId());
                this.pauseJob(job);
                flag = schedulerSevice.deleteJob(SchedulerUtil.getJobKey(job));

                if (!flag) {
                    throw new RuntimeException("删除job失败");
                }
            }
        } catch (SchedulerException e) {
            throw new RuntimeException("删除Job异常:" + e.getMessage(), e);
        }
	}
	
	/**
     * 暂停任务
     * @param job
     */
    public void pauseJob(SysJob job){
        try {
            this.schedulerSevice.getScheduler().pauseJob(SchedulerUtil.getJobKey(job));
        } catch (SchedulerException e) {
            throw new RuntimeException("暂停任务异常:"+e.getMessage(),e);
        }
    }
    /**
     * 恢复任务
     * @param job
     */
    public void resumeJob(SysJob job){
        try {
            this.schedulerSevice.getScheduler().resumeJob(SchedulerUtil.getJobKey(job));
        } catch (SchedulerException e) {
            throw new RuntimeException("恢复任务异常:"+e.getMessage(),e);
        }
    }
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysJob findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysJob
	 * @return
	 */
	public List<SysJob> findByNotNullProps(SysJob entity){
		
		SelectStatement<SysJob> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysJob
	 * @return
	 */
	public void updateNotNullPropsById(SysJob entity){
		
		UpdateStatement<SysJob> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	@Override
	public List<SysJob> findByQueryParam(SysJobParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysJobParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}
	
	@Transactional
	@Override
	public int updateClause(SysJob sysJob){
		SchedulerUtil.checkJobClass(sysJob.getJobClass());
		int row = this.repo.updateClause(sysJob);
		
		return row;
	}
	
	@Override
	public List<SysJob> findAll() {
		SysJob.EntityNode n = SysJob.EntityNode.INSTANCE;
		SelectStatement<SysJob> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}

	@Override
	public SysJob findByGroupIdAndJobClass(Integer groupId, String jobClass) {
		SysJob.EntityNode n = SysJob.EntityNode.INSTANCE;
		SelectStatement<SysJob> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.groupId.eq(groupId)).add(n.jobClass.eq(jobClass));
		
		return this.repo.selectByStatement(st).stream().findFirst().orElse(null);
	}
	

}

