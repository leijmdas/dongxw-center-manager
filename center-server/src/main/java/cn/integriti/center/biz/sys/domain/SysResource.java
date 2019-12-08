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
 * SysResource
 * @author generator
 * @date 2015年12月05日
 */
@Table(SysResource.EntityNode.class)
public class SysResource  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "主键",autoIncrement=true)	
	private Integer id;
	/**
	  * 组id
	  * nullable:false,length:32
	  */
	@Column(comment = "组id")	
	@NotNull
	private Integer groupId;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@Column(comment = "名称")	
	@NotNull
	private String resName;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@Column(comment = "编码")	
	@NotNull
	private String resCode;
	/**
	  * 类型(1:菜单;2:按钮)
	  * nullable:false,length:4
	  */
	@Column(comment = "类型(1:菜单;2:按钮)")	
	@NotNull
	private Byte type;
	/**
	  * 资源路径
	  * nullable:false,length:255
	  */
	@Column(comment = "资源路径")	
	@NotNull
	private String resPath;
	@Column(comment = "排序号")	
	@NotNull
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
    
    public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
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

    public static class EntityNode extends AbstractEntityNode<SysResource> {
        public static final EntityNode INSTANCE = new EntityNode("tsr");;
    	/** 主键 */
        public FieldNode<SysResource, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 组id */
        public FieldNode<SysResource, Integer> groupId =  createFieldNode("groupId","group_id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysResource, String> resName =  createFieldNode("resName","res_name",String.class,JdbcType.VARCHAR);
    	/** 编码 */
        public FieldNode<SysResource, String> resCode =  createFieldNode("resCode","res_code",String.class,JdbcType.VARCHAR);
    	/** 类型(1:菜单;2:按钮) */
        public FieldNode<SysResource, Byte> type =  createFieldNode("type","type",Byte.class,JdbcType.TINYINT);
    	/** 资源路径 */
        public FieldNode<SysResource, String> resPath =  createFieldNode("resPath","res_path",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysResource, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
        /** 排序号 */
        public FieldNode<SysResource, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	/** 备注 */
        public FieldNode<SysResource, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysResource, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysResource, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysResource, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysResource, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysResource.class,"t_sys_resource",alias);
        }
    }

	//-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysResource> {

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
    
    private SysResourceGroup sysResourceGroup;
	public SysResourceGroup getSysResourceGroup() {
		return sysResourceGroup;
	}
	public void setSysResourceGroup(SysResourceGroup sysResourceGroup) {
		this.sysResourceGroup = sysResourceGroup;
	}
    
}