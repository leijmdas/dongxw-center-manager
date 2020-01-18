package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysOrg
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysOrg")
public class SysOrgDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 企业ID
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "企业ID",required = true,notes = "企业ID ")
	private Integer corpId;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "名称",required = true,notes = "名称 ")
	private String orgName;
	/**
	  * pid
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "pid",required = true,notes = "pid ")
	private Integer pid;
	/**
	  * 路径
	  * nullable:false,length:120
	  */
	@ApiModelProperty(value = "路径",required = true,notes = "路径 ")
	private String orgPath;
	/**
	  * 排序号
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "排序号",required = false,notes = "排序号 ")
	private Integer orderNum;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态(1:启用;0:停用)",required = true,notes = "状态(1:启用;0:停用) ")
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@ApiModelProperty(value = "备注",required = false,notes = "备注 ")
	private String remark;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "创建人",required = true,notes = "创建人 ")
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "创建时间",required = true,notes = "创建时间 ")
	private Date createOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "操作人",required = true,notes = "操作人 ")
	private Integer opBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "操作时间",required = true,notes = "操作时间 ")
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getCorpId(){
    	return this.corpId;
    }
    public void setCorpId(Integer corpId){
    	this.corpId = corpId;
    }
    public String getOrgName(){
    	return this.orgName;
    }
    public void setOrgName(String orgName){
    	this.orgName = orgName;
    }
    public Integer getPid(){
    	return this.pid;
    }
    public void setPid(Integer pid){
    	this.pid = pid;
    }
    public String getOrgPath(){
    	return this.orgPath;
    }
    public void setOrgPath(String orgPath){
    	this.orgPath = orgPath;
    }
    public Integer getOrderNum(){
    	return this.orderNum;
    }
    public void setOrderNum(Integer orderNum){
    	this.orderNum = orderNum;
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
    // ==== 自定义属性 ====
}