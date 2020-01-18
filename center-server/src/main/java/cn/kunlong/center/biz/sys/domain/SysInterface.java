package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysInterface
 * @author generator
 * @date 2016年06月06日
 */
@Table(SysInterface.EntityNode.class)
public class SysInterface  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 域ID
	  * nullable:true,length:11
	  */
	@Column(comment = "域ID")	
	private Integer domainId;
	/**
	  * 名称
	  * nullable:true,length:64
	  */
	@Column(comment = "名称")	
	private String intfName;
	/**
	  * 请求超时
	  * nullable:true,length:11
	  */
	@Column(comment = "请求超时")	
	private Integer requestTimeout;
	/**
	  * 请求地址
	  * nullable:true,length:255
	  */
	@Column(comment = "请求地址")	
	private String requestUrl;
	/**
	  * 请求方式(1:GET,2:POST)
	  * nullable:true,length:4
	  */
	@Column(comment = "请求方式(1:GET,2:POST)")	
	private Byte requestMethod;
	/**
	  * 调用类型(1:同步,2:异步)
	  * nullable:true,length:4
	  */
	@Column(comment = "调用类型(1:同步,2:异步)")	
	private Byte invokeType;
	/**
	  * 调用回执(1:生成回执,0:不生成回执)
	  * nullable:true,length:4
	  */
	@Column(comment = "调用回执(1:生成回执,0:不生成回执)")	
	private Byte invokeReceipt;
	/**
	  * 状态
	  * nullable:true,length:4
	  */
	@Column(comment = "状态")	
	private Byte status;
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
	private Byte isDeleted;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getDomainId(){
    	return this.domainId;
    }
    public void setDomainId(Integer domainId){
    	this.domainId = domainId;
    }
    public String getIntfName(){
    	return this.intfName;
    }
    public void setIntfName(String intfName){
    	this.intfName = intfName;
    }
    public Integer getRequestTimeout(){
    	return this.requestTimeout;
    }
    public void setRequestTimeout(Integer requestTimeout){
    	this.requestTimeout = requestTimeout;
    }
    public String getRequestUrl(){
    	return this.requestUrl;
    }
    public void setRequestUrl(String requestUrl){
    	this.requestUrl = requestUrl;
    }
    public Byte getRequestMethod(){
    	return this.requestMethod;
    }
    public void setRequestMethod(Byte requestMethod){
    	this.requestMethod = requestMethod;
    }
    public Byte getInvokeType(){
    	return this.invokeType;
    }
    public void setInvokeType(Byte invokeType){
    	this.invokeType = invokeType;
    }
    public Byte getInvokeReceipt(){
    	return this.invokeReceipt;
    }
    public void setInvokeReceipt(Byte invokeReceipt){
    	this.invokeReceipt = invokeReceipt;
    }
    public Byte getStatus(){
    	return this.status;
    }
    public void setStatus(Byte status){
    	this.status = status;
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

    public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}


	public static class EntityNode extends AbstractEntityNode<SysInterface> {
        public static final EntityNode INSTANCE = new EntityNode("tsi");;
    	/**  */
        public FieldNode<SysInterface, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 域ID */
        public FieldNode<SysInterface, Integer> domainId =  createFieldNode("domainId","domain_id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysInterface, String> intfName =  createFieldNode("intfName","intf_name",String.class,JdbcType.VARCHAR);
    	/** 请求超时 */
        public FieldNode<SysInterface, Integer> requestTimeout =  createFieldNode("requestTimeout","request_timeout",Integer.class,JdbcType.INTEGER);
    	/** 请求地址 */
        public FieldNode<SysInterface, String> requestUrl =  createFieldNode("requestUrl","request_url",String.class,JdbcType.VARCHAR);
    	/** 请求方式(1:GET,2:POST) */
        public FieldNode<SysInterface, Byte> requestMethod =  createFieldNode("requestMethod","request_method",Byte.class,JdbcType.TINYINT);
    	/** 调用类型(1:同步,2:异步) */
        public FieldNode<SysInterface, Byte> invokeType =  createFieldNode("invokeType","invoke_type",Byte.class,JdbcType.TINYINT);
    	/** 调用回执(1:生成回执,0:不生成回执) */
        public FieldNode<SysInterface, Byte> invokeReceipt =  createFieldNode("invokeReceipt","invoke_receipt",Byte.class,JdbcType.TINYINT);
    	/** 状态 */
        public FieldNode<SysInterface, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysInterface, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysInterface, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysInterface, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysInterface, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysInterface, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
    	/** 是否已删除 */
        public FieldNode<SysInterface, Byte> isDeleted =  createFieldNode("isDeleted","is_deleted",Byte.class,JdbcType.TINYINT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysInterface.class,"t_sys_interface",alias);
        }
    }
    // ==== 自定义属性 ====
    

    private SysDomain sysDomain;
    private Integer countTrigger;
    
    private List<SysInterfaceTrigger> sysInterfaceTriggers;
    
    private List<SysInterfaceParam> sysInterfaceParams;
	public SysDomain getSysDomain() {
		return sysDomain;
	}
	public void setSysDomain(SysDomain sysDomain) {
		this.sysDomain = sysDomain;
	}
	public Integer getCountTrigger() {
		return countTrigger;
	}
	public void setCountTrigger(Integer countTrigger) {
		this.countTrigger = countTrigger;
	}
	public List<SysInterfaceTrigger> getSysInterfaceTriggers() {
		return sysInterfaceTriggers;
	}
	public void setSysInterfaceTriggers(List<SysInterfaceTrigger> sysInterfaceTriggers) {
		this.sysInterfaceTriggers = sysInterfaceTriggers;
	}
	public List<SysInterfaceParam> getSysInterfaceParams() {
		return sysInterfaceParams;
	}
	public void setSysInterfaceParams(List<SysInterfaceParam> sysInterfaceParams) {
		this.sysInterfaceParams = sysInterfaceParams;
	}
	
}