package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysAccount
 * @author generator
 * @date 2018年06月11日
 */
@ApiModel(value="SysAccount")
public class SysAccountDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 登录名
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "登录名",required = true,notes = "登录名 ")
	private String loginName;
	/**
	  * 真实姓名
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "真实姓名",required = false,notes = "真实姓名 ")
	private String realName;
	/**
	  * 密码
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "密码",required = true,notes = "密码 ")
	private String pwd;
	/**
	  * 密码盐
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "密码盐",required = true,notes = "密码盐 ")
	private String pwdSalt;
	/**
	  * 绑定电话
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "绑定电话",required = false,notes = "绑定电话 ")
	private String telNo;
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
	  * 创建时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "创建时间",required = true,notes = "创建时间 ")
	private Date createOn;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "创建人",required = true,notes = "创建人 ")
	private Integer createBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "操作时间",required = true,notes = "操作时间 ")
	private Date opOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "操作人",required = true,notes = "操作人 ")
	private Integer opBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getLoginName(){
    	return this.loginName;
    }
    public void setLoginName(String loginName){
    	this.loginName = loginName;
    }
    public String getRealName(){
    	return this.realName;
    }
    public void setRealName(String realName){
    	this.realName = realName;
    }
    public String getPwd(){
    	return this.pwd;
    }
    public void setPwd(String pwd){
    	this.pwd = pwd;
    }
    public String getPwdSalt(){
    	return this.pwdSalt;
    }
    public void setPwdSalt(String pwdSalt){
    	this.pwdSalt = pwdSalt;
    }
    public String getTelNo(){
    	return this.telNo;
    }
    public void setTelNo(String telNo){
    	this.telNo = telNo;
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
    public Date getCreateOn(){
    	return this.createOn;
    }
    public void setCreateOn(Date createOn){
    	this.createOn = createOn;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    public Date getOpOn(){
    	return this.opOn;
    }
    public void setOpOn(Date opOn){
    	this.opOn = opOn;
    }
    public Integer getOpBy(){
    	return this.opBy;
    }
    public void setOpBy(Integer opBy){
    	this.opBy = opBy;
    }
    // ==== 自定义属性 ====
}