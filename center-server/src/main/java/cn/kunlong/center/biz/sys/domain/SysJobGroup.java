package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;
import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysJobGroup
 * @author generator
 * @date 2016年06月05日
 */
@Table(SysJobGroup.EntityNode.class)
public class SysJobGroup  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 组名
	  * nullable:true,length:64
	  */
	@Column(comment = "组名")	
	private String groupName;
	/**
	  * 备注
	  * nullable:true,length:255
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建人
	  * nullable:true,length:11
	  */
	@Column(comment = "创建人")	
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:true,length:19
	  */
	@Column(comment = "创建时间")	
	private Date createOn;
	/**
	  * 更新人
	  * nullable:true,length:11
	  */
	@Column(comment = "更新人")	
	private Integer updateBy;
	/**
	  * 更新时间
	  * nullable:true,length:19
	  */
	@Column(comment = "更新时间")	
	private Date updateOn;
	/**
	  * 是否已删除
	  * nullable:true,length:255
	  */
	@Column(comment = "是否已删除")	
	private Integer isDeleted;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getGroupName(){
    	return this.groupName;
    }
    public void setGroupName(String groupName){
    	this.groupName = groupName;
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
    public Integer getUpdateBy(){
    	return this.updateBy;
    }
    public void setUpdateBy(Integer updateBy){
    	this.updateBy = updateBy;
    }
    public Date getUpdateOn(){
    	return this.updateOn;
    }
    public void setUpdateOn(Date updateOn){
    	this.updateOn = updateOn;
    }
   

    public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


	public static class EntityNode extends AbstractEntityNode<SysJobGroup> {
        public static final EntityNode INSTANCE = new EntityNode("tsjg");;
    	/**  */
        public FieldNode<SysJobGroup, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 组名 */
        public FieldNode<SysJobGroup, String> groupName =  createFieldNode("groupName","group_name",String.class,JdbcType.VARCHAR);
    	/** 备注 */
        public FieldNode<SysJobGroup, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysJobGroup, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysJobGroup, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysJobGroup, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysJobGroup, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
    	/** 是否已删除 */
        public FieldNode<SysJobGroup, Integer> isDeleted =  createFieldNode("isDeleted","is_deleted",Integer.class,JdbcType.TINYINT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysJobGroup.class,"t_sys_job_group",alias);
        }
    }
  //-- 实体参数(允许新增属性) 
  	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysJobGroup> {
  		
  	}
    // ==== 自定义属性 ====
}