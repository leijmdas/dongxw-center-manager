package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysUser
 * @author generator
 * @date 2018年06月11日
 */
@ApiModel(value="SysUser")
public class SysUserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 工号
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "用户名",required = true,notes = "用户名 ")
	private String username;
	/**
	  * 密码
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "密码",required = false,notes = "密码 ")
	private String passwd;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String realname;
	/**
	  * 企业ID
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "企业ID",required = true,notes = "企业ID ")
	private Integer corpId;
	/**
	  * 组织结构ID
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "组织结构ID",required = true,notes = "组织结构ID ")
	private Integer orgId;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String mobileNo;
	/**
	  * 公司邮箱
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "公司邮箱",required = false,notes = "公司邮箱 ")
	private String email;
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
	/**
	  * 扩展属性
	  * nullable:false,length:1,000
	  */
	@ApiModelProperty(value = "扩展属性",required = true,notes = "扩展属性 ")
	private String extParams;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getUsername(){
    	return this.username;
    }
    public void setUsername(String username){
    	this.username = username;
    }
    public String getPasswd(){
    	return this.passwd;
    }
    public void setPasswd(String passwd){
    	this.passwd = passwd;
    }
    public String getRealname(){
    	return this.realname;
    }
    public void setRealname(String realname){
    	this.realname = realname;
    }
    public Integer getCorpId(){
    	return this.corpId;
    }
    public void setCorpId(Integer corpId){
    	this.corpId = corpId;
    }
    public Integer getOrgId(){
    	return this.orgId;
    }
    public void setOrgId(Integer orgId){
    	this.orgId = orgId;
    }
    public String getMobileNo(){
    	return this.mobileNo;
    }
    public void setMobileNo(String mobileNo){
    	this.mobileNo = mobileNo;
    }
    public String getEmail(){
    	return this.email;
    }
    public void setEmail(String email){
    	this.email = email;
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
    public String getExtParams(){
    	return this.extParams;
    }
    public void setExtParams(String extParams){
    	this.extParams = extParams;
    }
    // ==== 自定义属性 ====
    
    private SysOrgDTO sysOrg;
    
    private List<SysRoleDTO> sysRoles;
	public SysOrgDTO getSysOrg() {
		return sysOrg;
	}
	public void setSysOrg(SysOrgDTO sysOrg) {
		this.sysOrg = sysOrg;
	}
	public List<SysRoleDTO> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRoleDTO> sysRoles) {
		this.sysRoles = sysRoles;
	}
   
    
}