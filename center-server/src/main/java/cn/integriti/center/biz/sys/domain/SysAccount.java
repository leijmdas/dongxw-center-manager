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
 * SysAccount
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysAccount.EntityNode.class)
public class SysAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 登录名
	  * nullable:false,length:32
	  */
	@Column(comment = "登录名")	
	@NotNull
	private String loginName;
	/**
	  * 真实姓名
	  * nullable:true,length:64
	  */
	@Column(comment = "真实姓名")	
	private String realName;
	/**
	  * 密码
	  * nullable:false,length:64
	  */
	@Column(comment = "密码")	
	@NotNull
	private String pwd;
	/**
	  * 密码盐
	  * nullable:false,length:32
	  */
	@Column(comment = "密码盐")	
	@NotNull
	private String pwdSalt;
	/**
	  * 绑定电话
	  * nullable:true,length:32
	  */
	@Column(comment = "绑定电话")	
	private String telNo;
	/**
	  * 状态
	  * nullable:false,length:4
	  */
	@Column(comment = "状态")	
	@NotNull
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createOn;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@Column(comment = "创建人")	
	@NotNull
	private Integer createBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@Column(comment = "操作时间")	
	@NotNull
	private Date opOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@Column(comment = "操作人")	
	@NotNull
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

    public static class EntityNode extends AbstractEntityNode<SysAccount> {
        public static final EntityNode INSTANCE = new EntityNode("tsa");;
    	/**  */
        public FieldNode<SysAccount, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 登录名 */
        public FieldNode<SysAccount, String> loginName =  createFieldNode("loginName","login_name",String.class,JdbcType.VARCHAR);
    	/** 真实姓名 */
        public FieldNode<SysAccount, String> realName =  createFieldNode("realName","real_name",String.class,JdbcType.VARCHAR);
    	/** 密码 */
        public FieldNode<SysAccount, String> pwd =  createFieldNode("pwd","pwd",String.class,JdbcType.VARCHAR);
    	/** 密码盐 */
        public FieldNode<SysAccount, String> pwdSalt =  createFieldNode("pwdSalt","pwd_salt",String.class,JdbcType.VARCHAR);
    	/** 绑定电话 */
        public FieldNode<SysAccount, String> telNo =  createFieldNode("telNo","tel_no",String.class,JdbcType.VARCHAR);
    	/** 状态 */
        public FieldNode<SysAccount, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysAccount, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建时间 */
        public FieldNode<SysAccount, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 创建人 */
        public FieldNode<SysAccount, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysAccount, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysAccount, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysAccount.class,"t_sys_account",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysAccount> {
		private List<Integer> ids;
		private String keywords;


		public List<Integer> getIds() {
			return ids;
		}

		public void setIds(List<Integer> ids) {
			this.ids = ids;
		}

		public String getKeywords() {
			return keywords;
		}

		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		
	}
	
    // ==== 自定义属性 ====
}