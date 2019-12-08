package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysUserRole
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysUserRole")
public class SysUserRoleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer roleId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer userId;
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
    public Integer getRoleId(){
    	return this.roleId;
    }
    public void setRoleId(Integer roleId){
    	this.roleId = roleId;
    }
    public Integer getUserId(){
    	return this.userId;
    }
    public void setUserId(Integer userId){
    	this.userId = userId;
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