package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysUser
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysUser.EntityNode.class)
public class SysUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 工号
	  * nullable:false,length:32
	  */
	@Column(comment = "工号")	
	@NotNull
	private String username;
	/**
	  * 密码
	  * nullable:true,length:64
	  */
	@Column(comment = "密码")	
	private String passwd;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@Column(comment = "")	
	private String realname;
	/**
	  * 企业ID
	  * nullable:false,length:11
	  */
	@Column(comment = "企业ID")	
	@NotNull
	private Integer corpId;
	/**
	  * 组织结构ID
	  * nullable:false,length:11
	  */
	@Column(comment = "组织结构ID")	
	@NotNull
	private Integer orgId;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@Column(comment = "")	
	private String mobileNo;
	/**
	  * 公司邮箱
	  * nullable:true,length:255
	  */
	@Column(comment = "公司邮箱")	
	private String email;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@Column(comment = "创建人")	
	@NotNull
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@Column(comment = "操作人")	
	@NotNull
	private Integer opBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@Column(comment = "操作时间")	
	@NotNull
	private Date opOn;
	/**
	  * 扩展属性
	  * nullable:false,length:1,000
	  */
	@Column(comment = "扩展属性")	
	@NotNull
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

    public static class EntityNode extends AbstractEntityNode<SysUser> {
        public static final EntityNode INSTANCE = new EntityNode("tsu");;
    	/** 主键 */
        public FieldNode<SysUser, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 工号 */
        public FieldNode<SysUser, String> username =  createFieldNode("username","username",String.class,JdbcType.VARCHAR);
    	/** 密码 */
        public FieldNode<SysUser, String> passwd =  createFieldNode("passwd","passwd",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysUser, String> realname =  createFieldNode("realname","realname",String.class,JdbcType.VARCHAR);
    	/** 企业ID */
        public FieldNode<SysUser, Integer> corpId =  createFieldNode("corpId","corp_id",Integer.class,JdbcType.INTEGER);
    	/** 组织结构ID */
        public FieldNode<SysUser, Integer> orgId =  createFieldNode("orgId","org_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysUser, String> mobileNo =  createFieldNode("mobileNo","mobile_no",String.class,JdbcType.VARCHAR);
    	/** 公司邮箱 */
        public FieldNode<SysUser, String> email =  createFieldNode("email","email",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysUser, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysUser, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysUser, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysUser, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysUser, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysUser, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
    	/** 扩展属性 */
        public FieldNode<SysUser, String> extParams =  createFieldNode("extParams","ext_params",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysUser.class,"t_sys_user",alias);
        }
    }
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysUser> {
		
		private List<Integer> ids;
		/**
		 * 关联下级组织
		 */
		private Boolean cascadeOrgChild;
		
		/**
		 * 登陆名、姓名、电话或邮箱
		 */
		private String keyword;

		public Boolean getCascadeOrgChild() {
			return cascadeOrgChild;
		}

		public void setCascadeOrgChild(Boolean cascadeOrgChild) {
			this.cascadeOrgChild = cascadeOrgChild;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public List<Integer> getIds() {
			return ids;
		}

		public void setIds(List<Integer> ids) {
			this.ids = ids;
		}
		
	}
	
    // ==== 自定义属性 ====
	private SysOrg sysOrg;
	
	private List<SysRole> sysRoles;
	
	public SysOrg getSysOrg() {
		return sysOrg;
	}
	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}
	public List<SysRole> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	
}