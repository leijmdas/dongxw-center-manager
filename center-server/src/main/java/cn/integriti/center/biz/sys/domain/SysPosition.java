package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysOrg
 * @author generator
 * @date 2015年12月05日
 */
@Table(SysPosition.EntityNode.class)
public class SysPosition  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "主键",autoIncrement=true)	
	private Integer id;
	/**
	  * 用户名
	  * nullable:false,length:32
	  */
	@Column(comment = "岗位名称")	
	@NotNull
	private String positionName;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private Byte status;
	
	@Column(comment = "排序号")	
	@NotNull
	private Integer orderNum;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@Column(comment = "创建人")	
	@NotNull
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@Column(comment = "操作人")	
	@NotNull
	private Integer opBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@Column(comment = "操作时间")	
	@NotNull
	private Date opOn;
	
	@Column(comment = "所属组织结构id")	
	@NotNull
	private Integer orgId;
	
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getPositionName(){
    	return this.positionName;
    }
    public void setPositionName(String orgName){
    	this.positionName = orgName;
    }
    
    public Byte getStatus(){
    	return this.status;
    }
    public void setStatus(Byte status){
    	this.status = status;
    }
    
    public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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
    public Integer getOpBy(){
    	return this.opBy;
    }
    public void setOpBy(Integer opBy){
    	this.opBy = opBy;
    }
    public Date getOpOn(){
    	return this.opOn;
    }
    public void setOpOn(Date opOn){
    	this.opOn = opOn;
    }

    public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public static class EntityNode extends AbstractEntityNode<SysPosition> {
        public static final EntityNode INSTANCE = new EntityNode("tsp");;
    	/** 主键 */
        public FieldNode<SysPosition, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 用户名 */
        public FieldNode<SysPosition, String> positionName =  createFieldNode("positionName","position_name",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysPosition, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
        /** 排序号 */
        public FieldNode<SysPosition, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	/** 备注 */
        public FieldNode<SysPosition, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysPosition, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysPosition, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysPosition, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysPosition, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        public FieldNode<SysPosition, Integer> orgId =  createFieldNode("orgId","org_id",Integer.class,JdbcType.INTEGER);
    	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysPosition.class,"t_sys_position",alias);
        }
    }
    // ==== 自定义属性 ====
    
    private SysOrg sysOrg;//所属组织
	public SysOrg getSysOrg() {
		return sysOrg;
	}
	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}
    
	
    
}