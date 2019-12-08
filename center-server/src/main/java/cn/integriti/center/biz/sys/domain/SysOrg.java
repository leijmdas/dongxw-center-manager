package cn.integriti.center.biz.sys.domain;

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
 * SysOrg
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysOrg.EntityNode.class)
public class SysOrg implements Serializable {
	
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
	private String orgName;
	/**
	  * pid
	  * nullable:false,length:11
	  */
	@Column(comment = "pid")	
	@NotNull
	private Integer pid;
	/**
	  * 路径
	  * nullable:false,length:120
	  */
	@Column(comment = "路径")	
	@NotNull
	private String orgPath;
	/**
	  * 排序号
	  * nullable:true,length:11
	  */
	@Column(comment = "排序号")	
	private Integer orderNum;
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
    public String getOrgName(){
    	return this.orgName;
    }
    public void setOrgName(String orgName){
    	this.orgName = orgName;
    }
    public Integer getPid(){
    	return this.pid;
    }
    public void setPid(Integer pid){
    	this.pid = pid;
    }
    public String getOrgPath(){
    	return this.orgPath;
    }
    public void setOrgPath(String orgPath){
    	this.orgPath = orgPath;
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

    public static class EntityNode extends AbstractEntityNode<SysOrg> {
        public static final EntityNode INSTANCE = new EntityNode("tso");;
    	/** 主键 */
        public FieldNode<SysOrg, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 企业ID */
        public FieldNode<SysOrg, Integer> corpId =  createFieldNode("corpId","corp_id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysOrg, String> orgName =  createFieldNode("orgName","org_name",String.class,JdbcType.VARCHAR);
    	/** pid */
        public FieldNode<SysOrg, Integer> pid =  createFieldNode("pid","pid",Integer.class,JdbcType.INTEGER);
    	/** 路径 */
        public FieldNode<SysOrg, String> orgPath =  createFieldNode("orgPath","org_path",String.class,JdbcType.VARCHAR);
    	/** 排序号 */
        public FieldNode<SysOrg, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysOrg, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysOrg, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysOrg, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysOrg, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysOrg, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysOrg, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysOrg.class,"t_sys_org",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysOrg> {

		/**
		 * 级联子部门
		 */
		private Boolean cascadeChild;
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

		public Boolean getCascadeChild() {
			return cascadeChild;
		}

		public void setCascadeChild(Boolean cascadeChild) {
			this.cascadeChild = cascadeChild;
		}
		
	}
	
    // ==== 自定义属性 ====
}