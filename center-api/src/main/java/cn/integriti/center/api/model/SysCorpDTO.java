package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysCorp
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysCorp")
public class SysCorpDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 企业编码
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "企业编码",required = true,notes = "企业编码 ")
	private String corpCode;
	/**
	  * 企业名称
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "企业名称",required = true,notes = "企业名称 ")
	private String corpName;
	/**
	  * 联系人
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "联系人",required = false,notes = "联系人 ")
	private String contactMan;
	/**
	  * 联系电话
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "联系电话",required = false,notes = "联系电话 ")
	private String contactNo;
	/**
	  * 地址
	  * nullable:true,length:250
	  */
	@ApiModelProperty(value = "地址",required = false,notes = "地址 ")
	private String address;
	/**
	  * 网址
	  * nullable:true,length:250
	  */
	@ApiModelProperty(value = "网址",required = false,notes = "网址 ")
	private String website;
	/**
	  * 状态
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态",required = true,notes = "状态 ")
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@ApiModelProperty(value = "备注",required = false,notes = "备注 ")
	private String remark;
	/**
	  * 注册时间
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "注册时间",required = false,notes = "注册时间 ")
	private Date registOn;
	/**
	  * 审核状态
	  * nullable:true,length:4
	  */
	@ApiModelProperty(value = "审核状态",required = false,notes = "审核状态 ")
	private Byte auditStatus;
	/**
	  * 审核时间
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "审核时间",required = false,notes = "审核时间 ")
	private Date auditOn;
	/**
	  * 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date createOn;
	/**
	  * 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCorpCode(){
    	return this.corpCode;
    }
    public void setCorpCode(String corpCode){
    	this.corpCode = corpCode;
    }
    public String getCorpName(){
    	return this.corpName;
    }
    public void setCorpName(String corpName){
    	this.corpName = corpName;
    }
    public String getContactMan(){
    	return this.contactMan;
    }
    public void setContactMan(String contactMan){
    	this.contactMan = contactMan;
    }
    public String getContactNo(){
    	return this.contactNo;
    }
    public void setContactNo(String contactNo){
    	this.contactNo = contactNo;
    }
    public String getAddress(){
    	return this.address;
    }
    public void setAddress(String address){
    	this.address = address;
    }
    public String getWebsite(){
    	return this.website;
    }
    public void setWebsite(String website){
    	this.website = website;
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
    public Date getRegistOn(){
    	return this.registOn;
    }
    public void setRegistOn(Date registOn){
    	this.registOn = registOn;
    }
    public Byte getAuditStatus(){
    	return this.auditStatus;
    }
    public void setAuditStatus(Byte auditStatus){
    	this.auditStatus = auditStatus;
    }
    public Date getAuditOn(){
    	return this.auditOn;
    }
    public void setAuditOn(Date auditOn){
    	this.auditOn = auditOn;
    }
    public Date getCreateOn(){
    	return this.createOn;
    }
    public void setCreateOn(Date createOn){
    	this.createOn = createOn;
    }
    public Date getOpOn(){
    	return this.opOn;
    }
    public void setOpOn(Date opOn){
    	this.opOn = opOn;
    }
    // ==== 自定义属性 ====
}