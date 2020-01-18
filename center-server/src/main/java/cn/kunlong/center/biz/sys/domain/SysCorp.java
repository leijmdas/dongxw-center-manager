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
 * SysCorp
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysCorp.EntityNode.class)
public class SysCorp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 企业编码
	  * nullable:false,length:32
	  */
	@Column(comment = "企业编码")	
	@NotNull
	private String corpCode;
	/**
	  * 企业名称
	  * nullable:false,length:128
	  */
	@Column(comment = "企业名称")	
	@NotNull
	private String corpName;
	/**
	  * 联系人
	  * nullable:true,length:32
	  */
	@Column(comment = "联系人")	
	private String contactMan;
	/**
	  * 联系电话
	  * nullable:true,length:32
	  */
	@Column(comment = "联系电话")	
	private String contactNo;
	/**
	  * 地址
	  * nullable:true,length:250
	  */
	@Column(comment = "地址")	
	private String address;
	/**
	  * 网址
	  * nullable:true,length:250
	  */
	@Column(comment = "网址")	
	private String website;
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
	  * 注册时间
	  * nullable:true,length:19
	  */
	@Column(comment = "注册时间")	
	private Date registOn;
	/**
	  * 审核状态
	  * nullable:true,length:4
	  */
	@Column(comment = "审核状态")	
	private Byte auditStatus;
	/**
	  * 审核时间
	  * nullable:true,length:19
	  */
	@Column(comment = "审核时间")	
	private Date auditOn;
	/**
	  * 创建时间
	  * nullable:true,length:19
	  */
	@Column(comment = "创建时间")	
	private Date createOn;
	/**
	  * 更新时间
	  * nullable:true,length:19
	  */
	@Column(comment = "更新时间")	
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCorpCode(){
    	return this.corpCode;
    }
    public void setCorpCode(String corpCode){
    	this.corpCode = corpCode;
    }
    public String getCorpName(){
    	return this.corpName;
    }
    public void setCorpName(String corpName){
    	this.corpName = corpName;
    }
    public String getContactMan(){
    	return this.contactMan;
    }
    public void setContactMan(String contactMan){
    	this.contactMan = contactMan;
    }
    public String getContactNo(){
    	return this.contactNo;
    }
    public void setContactNo(String contactNo){
    	this.contactNo = contactNo;
    }
    public String getAddress(){
    	return this.address;
    }
    public void setAddress(String address){
    	this.address = address;
    }
    public String getWebsite(){
    	return this.website;
    }
    public void setWebsite(String website){
    	this.website = website;
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
    public Date getRegistOn(){
    	return this.registOn;
    }
    public void setRegistOn(Date registOn){
    	this.registOn = registOn;
    }
    public Byte getAuditStatus(){
    	return this.auditStatus;
    }
    public void setAuditStatus(Byte auditStatus){
    	this.auditStatus = auditStatus;
    }
    public Date getAuditOn(){
    	return this.auditOn;
    }
    public void setAuditOn(Date auditOn){
    	this.auditOn = auditOn;
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

    public static class EntityNode extends AbstractEntityNode<SysCorp> {
        public static final EntityNode INSTANCE = new EntityNode("tsc");;
    	/**  */
        public FieldNode<SysCorp, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 企业编码 */
        public FieldNode<SysCorp, String> corpCode =  createFieldNode("corpCode","corp_code",String.class,JdbcType.VARCHAR);
    	/** 企业名称 */
        public FieldNode<SysCorp, String> corpName =  createFieldNode("corpName","corp_name",String.class,JdbcType.VARCHAR);
    	/** 联系人 */
        public FieldNode<SysCorp, String> contactMan =  createFieldNode("contactMan","contact_man",String.class,JdbcType.VARCHAR);
    	/** 联系电话 */
        public FieldNode<SysCorp, String> contactNo =  createFieldNode("contactNo","contact_no",String.class,JdbcType.VARCHAR);
    	/** 地址 */
        public FieldNode<SysCorp, String> address =  createFieldNode("address","address",String.class,JdbcType.VARCHAR);
    	/** 网址 */
        public FieldNode<SysCorp, String> website =  createFieldNode("website","website",String.class,JdbcType.VARCHAR);
    	/** 状态 */
        public FieldNode<SysCorp, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysCorp, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 注册时间 */
        public FieldNode<SysCorp, Date> registOn =  createFieldNode("registOn","regist_on",Date.class,JdbcType.TIMESTAMP);
    	/** 审核状态 */
        public FieldNode<SysCorp, Byte> auditStatus =  createFieldNode("auditStatus","audit_status",Byte.class,JdbcType.TINYINT);
    	/** 审核时间 */
        public FieldNode<SysCorp, Date> auditOn =  createFieldNode("auditOn","audit_on",Date.class,JdbcType.TIMESTAMP);
    	/** 创建时间 */
        public FieldNode<SysCorp, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新时间 */
        public FieldNode<SysCorp, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysCorp.class,"t_sys_corp",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysCorp> {
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