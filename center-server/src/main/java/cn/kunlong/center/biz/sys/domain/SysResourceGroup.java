package cn.kunlong.center.biz.sys.domain;

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
 * SysResourceGroup
 * @author generator
 * @date 2015年12月05日
 */
@Table(SysResourceGroup.EntityNode.class)
public class SysResourceGroup  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 组类型(1:系统后台,2:医院前端)
	  * nullable:false,length:11
	  */
	@Column(comment = "组类型(1:系统后台,2:医院前端)")	
	@NotNull
	private Byte groupType;
	/**
	  * 名称
	  * nullable:false,length:32
	  */
	@Column(comment = "名称")	
	@NotNull
	private String groupName;
	
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
	
	@Column
	private String iconClass;
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
	
	@Column(comment = "域ID")	
	@NotNull
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

    public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public Integer getDomainId() {
		return domainId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public static class EntityNode extends AbstractEntityNode<SysResourceGroup> {
        public static final EntityNode INSTANCE = new EntityNode("tsrg");;
    	/** 主键 */
        public FieldNode<SysResourceGroup, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 组类型(1:菜单,2:按钮) */
        public FieldNode<SysResourceGroup, Byte> groupType =  createFieldNode("groupType","group_type",Byte.class,JdbcType.TINYINT);
    	/** 名称 */
        public FieldNode<SysResourceGroup, String> groupName =  createFieldNode("groupName","group_name",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysResourceGroup, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysResourceGroup, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
        /** 图标样式 */
        public FieldNode<SysResourceGroup, String> iconClass =  createFieldNode("iconClass","icon_class",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysResourceGroup, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysResourceGroup, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysResourceGroup, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysResourceGroup, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
        public FieldNode<SysResourceGroup, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	
        public FieldNode<SysResourceGroup, Integer> domainId =  createFieldNode("domainId","domain_id",Integer.class,JdbcType.INTEGER);
    	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysResourceGroup.class,"t_sys_resource_group",alias);
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
    
    private List<SysResource> sysResources;
	public List<SysResource> getSysResources() {
		return sysResources;
	}
	public void setSysResources(List<SysResource> sysResources) {
		this.sysResources = sysResources;
	}
    
}