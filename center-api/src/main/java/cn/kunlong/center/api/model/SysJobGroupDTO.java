package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysJobGroup
 * @author generator
 * @date 2019年03月21日
 */
@ApiModel(value="SysJobGroupDTO",description="")
public class SysJobGroupDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 组名
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "组名",required = false,notes = "组名 ")
	private String groupName;
	/**
	  * 备注
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "备注",required = false,notes = "备注 ")
	private String remark;
	/**
	  * 创建人
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "创建人",required = false,notes = "创建人 ")
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "创建时间",required = false,notes = "创建时间 ")
	private Date createOn;
	/**
	  * 更新人
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "更新人",required = false,notes = "更新人 ")
	private Integer updateBy;
	/**
	  * 更新时间
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "更新时间",required = false,notes = "更新时间 ")
	private Date updateOn;
	/**
	  * 是否已删除
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "是否已删除",required = false,notes = "是否已删除 ")
	private Integer isDeleted;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getGroupName(){
    	return this.groupName;
    }
    public void setGroupName(String groupName){
    	this.groupName = groupName;
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
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
   
    // ==== 自定义属性 ====
}