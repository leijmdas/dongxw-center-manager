package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;

import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
/**
 * SysJob
 * @author generator
 * @date 2016年06月01日
 */
@Table(SysJob.EntityNode.class)
public class SysJob  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "")	
	private Integer id;
	/**
	  * 组id
	  * nullable:true,length:11
	  */
	@Column(comment = "组id")	
	private Integer groupId;
	/**
	  * 任务名称
	  * nullable:true,length:64
	  */
	@Column(comment = "任务名称")	
	private String jobName;
	/**
	  * 任务类型(1:HTTP;0:其它)
	  * nullable:true,length:4
	  */
	@Column(comment = "任务类型(1:HTTP;0:其它)")	
	private Byte jobType;
	/**
	  * 任务类
	  * nullable:true,length:255
	  */
	@Column(comment = "任务类")	
	private String jobClass;
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
	  * nullable:true,length:255
	  */
	@Column(comment = "是否已删除")	
	private Byte isDeleted;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getGroupId(){
    	return this.groupId;
    }
    public void setGroupId(Integer groupId){
    	this.groupId = groupId;
    }
    public String getJobName(){
    	return this.jobName;
    }
    public void setJobName(String jobName){
    	this.jobName = jobName;
    }
    public Byte getJobType(){
    	return this.jobType;
    }
    public void setJobType(Byte jobType){
    	this.jobType = jobType;
    }
    public String getJobClass(){
    	return this.jobClass;
    }
    public void setJobClass(String jobClass){
    	this.jobClass = jobClass;
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
    public Byte getIsDeleted(){
    	return this.isDeleted;
    }
    public void setIsDeleted(Byte isDeleted){
    	this.isDeleted = isDeleted;
    }

    public static class EntityNode extends AbstractEntityNode<SysJob> {
        public static final EntityNode INSTANCE = new EntityNode("tsj");;
    	/**  */
        public FieldNode<SysJob, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 组id */
        public FieldNode<SysJob, Integer> groupId =  createFieldNode("groupId","group_id",Integer.class,JdbcType.INTEGER);
    	/** 任务名称 */
        public FieldNode<SysJob, String> jobName =  createFieldNode("jobName","job_name",String.class,JdbcType.VARCHAR);
    	/** 任务类型(1:HTTP;0:其它) */
        public FieldNode<SysJob, Byte> jobType =  createFieldNode("jobType","job_type",Byte.class,JdbcType.TINYINT);
    	/** 任务类 */
        public FieldNode<SysJob, String> jobClass =  createFieldNode("jobClass","job_class",String.class,JdbcType.VARCHAR);
    	/** 备注 */
        public FieldNode<SysJob, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysJob, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysJob, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysJob, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysJob, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
    	/** 是否已删除 */
        public FieldNode<SysJob, Byte> isDeleted =  createFieldNode("isDeleted","is_deleted",Byte.class,JdbcType.TINYINT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysJob.class,"t_sys_job",alias);
        }
    }
    // ==== 自定义属性 ====
    
    private SysJobGroup sysJobGroup;
    
	public SysJobGroup getSysJobGroup() {
		return sysJobGroup;
	}
	public void setSysJobGroup(SysJobGroup sysJobGroup) {
		this.sysJobGroup = sysJobGroup;
	}
    
    
}