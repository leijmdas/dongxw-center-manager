package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysRole
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysRole")
public class SysRoleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	
	private Integer corpId;
	
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer domainId;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "名称",required = true,notes = "名称 ")
	private String roleName;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "编码",required = true,notes = "编码 ")
	private String roleCode;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态(1:启用;0:停用)",required = true,notes = "状态(1:启用;0:停用) ")
	private Byte status;
	
	private Integer type;
	
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
    public Integer getDomainId(){
    	return this.domainId;
    }
    public void setDomainId(Integer domainId){
    	this.domainId = domainId;
    }
    public String getRoleName(){
    	return this.roleName;
    }
    public void setRoleName(String roleName){
    	this.roleName = roleName;
    }
    public String getRoleCode(){
    	return this.roleCode;
    }
    public void setRoleCode(String roleCode){
    	this.roleCode = roleCode;
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
	public Integer getCorpId() {
		return corpId;
	}
	public void setCorpId(Integer corpId) {
		this.corpId = corpId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
    
    // ==== 自定义属性 ====
}