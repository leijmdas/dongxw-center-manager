package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysResource
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysResource")
public class SysResourceDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 组id
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "组id",required = true,notes = "组id ")
	private Integer groupId;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "名称",required = true,notes = "名称 ")
	private String resName;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "编码",required = true,notes = "编码 ")
	private String resCode;
	/**
	  * 类型(1:菜单;2:按钮)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "类型(1:菜单;2:按钮)",required = true,notes = "类型(1:菜单;2:按钮) ")
	private Byte type;
	/**
	  * 资源路径
	  * nullable:false,length:255
	  */
	@ApiModelProperty(value = "资源路径",required = true,notes = "资源路径 ")
	private String resPath;
	/**
	  * 排序
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "排序",required = false,notes = "排序 ")
	private Integer orderNum;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态(1:启用;0:停用)",required = true,notes = "状态(1:启用;0:停用) ")
	private Byte status;
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
    public String getResName(){
    	return this.resName;
    }
    public void setResName(String resName){
    	this.resName = resName;
    }
    public String getResCode(){
    	return this.resCode;
    }
    public void setResCode(String resCode){
    	this.resCode = resCode;
    }
    public Byte getType(){
    	return this.type;
    }
    public void setType(Byte type){
    	this.type = type;
    }
    public String getResPath(){
    	return this.resPath;
    }
    public void setResPath(String resPath){
    	this.resPath = resPath;
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