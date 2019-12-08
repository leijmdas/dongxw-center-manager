package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Byte;
import java.lang.String;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysResourceGroup
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysResourceGroup")
public class SysResourceGroupDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 组类型(1:系统后台,2:医院前端)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "组类型(1:系统后台,2:医院前端)",required = true,notes = "组类型(1:系统后台,2:医院前端) ")
	private Byte groupType;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "名称",required = true,notes = "名称 ")
	private String groupName;
	/**
	  * 排序
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "排序",required = true,notes = "排序 ")
	private Integer orderNum;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态(1:启用;0:停用)",required = true,notes = "状态(1:启用;0:停用) ")
	private Byte status;
	/**
	  * 样式
	  * nullable:true,length:54
	  */
	@ApiModelProperty(value = "样式",required = false,notes = "样式 ")
	private String iconClass;
	/**
	  * 备注
	  * nullable:true,length:255
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
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer domainId;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Byte getGroupType(){
    	return this.groupType;
    }
    public void setGroupType(Byte groupType){
    	this.groupType = groupType;
    }
    public String getGroupName(){
    	return this.groupName;
    }
    public void setGroupName(String groupName){
    	this.groupName = groupName;
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
    public String getIconClass(){
    	return this.iconClass;
    }
    public void setIconClass(String iconClass){
    	this.iconClass = iconClass;
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
    public Integer getDomainId(){
    	return this.domainId;
    }
    public void setDomainId(Integer domainId){
    	this.domainId = domainId;
    }
    // ==== 自定义属性 ====
    private List<SysResourceDTO> sysResources;
	public List<SysResourceDTO> getSysResources() {
		return sysResources;
	}
	public void setSysResources(List<SysResourceDTO> sysResources) {
		this.sysResources = sysResources;
	}
    
}