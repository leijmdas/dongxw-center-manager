package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysHttpJob
 * @author generator
 * @date 2019年03月21日
 */
@ApiModel(value="SysHttpJobDTO",description="")
public class SysHttpJobDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer groupId;
	/**
	  * 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String name;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String expression;
	/**
	  * 
	  * nullable:false,length:256
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String url;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer status;
	/**
	  * 
	  * nullable:true,length:500
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String remark;
	/**
	  * 
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Date createOn;
	/**
	  * 
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date opOn;
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
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getExpression(){
    	return this.expression;
    }
    public void setExpression(String expression){
    	this.expression = expression;
    }
    public String getUrl(){
    	return this.url;
    }
    public void setUrl(String url){
    	this.url = url;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
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
    public Date getOpOn(){
    	return this.opOn;
    }
    public void setOpOn(Date opOn){
    	this.opOn = opOn;
    }
    // ==== 自定义属性 ====
    private SysJobGroupDTO sysJobGroup;
	public SysJobGroupDTO getSysJobGroup() {
		return sysJobGroup;
	}
	public void setSysJobGroup(SysJobGroupDTO sysJobGroup) {
		this.sysJobGroup = sysJobGroup;
	}
	
    
}