package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysJobTrigger
 * @author generator
 * @date 2016年06月01日
 */
@Table(SysJobTrigger.EntityNode.class)
public class SysJobTrigger  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "",autoIncrement=true)	
	private Integer id;
	/**
	  * 任务id
	  * nullable:true,length:11
	  */
	@Column(comment = "任务id")	
	private Integer jobId;
	/**
	  * 触发器名称
	  * nullable:true,length:64
	  */
	@Column(comment = "触发器名称")	
	private String triggerName;
	/**
	  * 优先级
	  * nullable:true,length:11
	  */
	@Column(comment = "优先级")	
	private Integer priority;
	/**
	  * 表达式
	  * nullable:true,length:120
	  */
	@Column(comment = "表达式")	
	private String cronExpression;
	/**
	  * 备注
	  * nullable:true,length:255
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建人
	  * nullable:true,length:11
	  */
	@Column(comment = "创建人")	
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:true,length:19
	  */
	@Column(comment = "创建时间")	
	private Date createOn;
	/**
	  * 更新人
	  * nullable:true,length:11
	  */
	@Column(comment = "更新人")	
	private Integer updateBy;
	/**
	  * 更新时间
	  * nullable:true,length:19
	  */
	@Column(comment = "更新时间")	
	private Date updateOn;
	/**
	  * 是否已删除
	  * nullable:true,length:1
	  */
	@Column(comment = "是否已删除")	
	private Boolean isDeleted;
	
	
	public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getJobId(){
    	return this.jobId;
    }
    public void setJobId(Integer jobId){
    	this.jobId = jobId;
    }
    public String getTriggerName(){
    	return this.triggerName;
    }
    public void setTriggerName(String triggerName){
    	this.triggerName = triggerName;
    }
    public Integer getPriority(){
    	return this.priority;
    }
    public void setPriority(Integer priority){
    	this.priority = priority;
    }
    public String getCronExpression(){
    	return this.cronExpression;
    }
    public void setCronExpression(String cronExpression){
    	this.cronExpression = cronExpression;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    public Date getCreateOn(){
    	return this.createOn;
    }
    public void setCreateOn(Date createOn){
    	this.createOn = createOn;
    }
    public Integer getUpdateBy(){
    	return this.updateBy;
    }
    public void setUpdateBy(Integer updateBy){
    	this.updateBy = updateBy;
    }
    public Date getUpdateOn(){
    	return this.updateOn;
    }
    public void setUpdateOn(Date updateOn){
    	this.updateOn = updateOn;
    }

    public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public static class EntityNode extends AbstractEntityNode<SysJobTrigger> {
        public static final EntityNode INSTANCE = new EntityNode("tsjt");;
    	/**  */
        public FieldNode<SysJobTrigger, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 任务id */
        public FieldNode<SysJobTrigger, Integer> jobId =  createFieldNode("jobId","job_id",Integer.class,JdbcType.INTEGER);
    	/** 触发器名称 */
        public FieldNode<SysJobTrigger, String> triggerName =  createFieldNode("triggerName","trigger_name",String.class,JdbcType.VARCHAR);
    	/** 优先级 */
        public FieldNode<SysJobTrigger, Integer> priority =  createFieldNode("priority","priority",Integer.class,JdbcType.INTEGER);
    	/** 表达式 */
        public FieldNode<SysJobTrigger, String> cronExpression =  createFieldNode("cronExpression","cron_expression",String.class,JdbcType.VARCHAR);
    	/** 备注 */
        public FieldNode<SysJobTrigger, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysJobTrigger, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysJobTrigger, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysJobTrigger, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysJobTrigger, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
    	/** 是否已删除 */
        public FieldNode<SysJobTrigger, Boolean> isDeleted =  createFieldNode("isDeleted","is_deleted",Boolean.class,JdbcType.TINYINT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysJobTrigger.class,"t_sys_job_trigger",alias);
        }
    }
    // ==== 自定义属性 ====

	
	private SysJob sysJob;
    private SysInterface  sysInterface;
    private SysInterfaceTrigger  sysInterfaceTrigger;
    private SysDomain sysDomain;
    
	public SysJob getSysJob() {
		return sysJob;
	}
	public void setSysJob(SysJob sysJob) {
		this.sysJob = sysJob;
	}
	public SysInterface getSysInterface() {
		return sysInterface;
	}
	public void setSysInterface(SysInterface sysInterface) {
		this.sysInterface = sysInterface;
	}
	public SysInterfaceTrigger getSysInterfaceTrigger() {
		return sysInterfaceTrigger;
	}
	public void setSysInterfaceTrigger(SysInterfaceTrigger sysInterfaceTrigger) {
		this.sysInterfaceTrigger = sysInterfaceTrigger;
	}
	public SysDomain getSysDomain() {
		return sysDomain;
	}
	public void setSysDomain(SysDomain sysDomain) {
		this.sysDomain = sysDomain;
	}
	
	public Map<String,Object> getTriggerData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private QuartzTrigger quartzTrigger;
	
	public QuartzTrigger getQuartzTrigger() {
		return quartzTrigger;
	}
	public void setQuartzTrigger(QuartzTrigger quartzTrigger) {
		this.quartzTrigger = quartzTrigger;
	}


	public static final class QuartzTrigger {
		private String triggerState;
		
		private Date prevFireTime ;
		private Date nextFireTime;
		
		
	    public String getTriggerState() {
			return triggerState;
		}
		public void setTriggerState(String triggerState) {
			this.triggerState = triggerState;
		}
		public Date getPrevFireTime() {
			return prevFireTime;
		}
		public void setPrevFireTime(Date prevFireTime) {
			this.prevFireTime = prevFireTime;
		}
		public Date getNextFireTime() {
			return nextFireTime;
		}
		public void setNextFireTime(Date nextFireTime) {
			this.nextFireTime = nextFireTime;
		}
	}
}