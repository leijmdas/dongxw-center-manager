package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import java.util.List;
/**
 * SysRole
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysRole.EntityNode.class)
public class SysRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 企业ID
	  * nullable:false,length:11
	  */
	@Column(comment = "企业ID")	
	@NotNull
	private Integer corpId;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@Column(comment = "名称")	
	@NotNull
	private String roleName;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@Column(comment = "编码")	
	@NotNull
	private String roleCode;
	/**
	  * 类型(1: 功能角色, 2: 数据角色)
	  * nullable:false,length:11
	  */
	@Column(comment = "类型(1: 功能角色, 2: 数据角色)")	
	@NotNull
	private Integer type;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:255
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
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getCorpId(){
    	return this.corpId;
    }
    public void setCorpId(Integer corpId){
    	this.corpId = corpId;
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
    public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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

    public static class EntityNode extends AbstractEntityNode<SysRole> {
        public static final EntityNode INSTANCE = new EntityNode("tsr");;
    	/** 主键 */
        public FieldNode<SysRole, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 企业ID */
        public FieldNode<SysRole, Integer> corpId =  createFieldNode("corpId","corp_id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysRole, String> roleName =  createFieldNode("roleName","role_name",String.class,JdbcType.VARCHAR);
    	/** 编码 */
        public FieldNode<SysRole, String> roleCode =  createFieldNode("roleCode","role_code",String.class,JdbcType.VARCHAR);
    	/** 类型(1: 功能角色, 2: 数据角色) */
        public FieldNode<SysRole, Integer> type =  createFieldNode("type","type",Integer.class,JdbcType.INTEGER);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysRole, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysRole, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysRole, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysRole, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysRole, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysRole, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysRole.class,"t_sys_role",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysRole> {

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
	
	private List<SysResource> sysResources;
	public List<SysResource> getSysResources() {
		return sysResources;
	}
	public void setSysResources(List<SysResource> sysResources) {
		this.sysResources = sysResources;
	}

	/**
	 * 功能角色
	 */
	public static final Integer TYPE_FUNCTION = 1;

	/**
	 * 数据角色
	 */
	public static final Integer TYPE_DATA = 2;
}