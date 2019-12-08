package cn.integriti.center.biz.sys.dto;




public class ScheduleJobDTO {

	  /** 任务id */
    private Integer jobId;
 
    /** 任务名称 */
    private String jobName;
 
    /** 任务分组 */
    private String groupId;
    
    /**任务类型(1:HTTP;0:其它)*/
    private Byte jobType;
 
    /** 任务运行时间表达式 */
    private String cronExpression;
 
    /** 任务描述 */
    private String desc;
    
    /**触发器名称*/
    private String triggerName;
    
    /**优先级*/
    private Integer priority;
    
    /**是否已删除触发器*/
    private Byte isDeleteTrigger;
    
    /**是否已删除任务*/
    private Byte isDeleteJob;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Byte getJobType() {
		return jobType;
	}

	public void setJobType(Byte jobType) {
		this.jobType = jobType;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Byte getIsDeleteTrigger() {
		return isDeleteTrigger;
	}

	public void setIsDeleteTrigger(Byte isDeleteTrigger) {
		this.isDeleteTrigger = isDeleteTrigger;
	}

	public Byte getIsDeleteJob() {
		return isDeleteJob;
	}

	public void setIsDeleteJob(Byte isDeleteJob) {
		this.isDeleteJob = isDeleteJob;
	}
}
