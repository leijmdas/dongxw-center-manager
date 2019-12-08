package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.util.Date;
/**
 * SysRoleResource
 * @author generator
 * @date 2018年06月11日
 */
@Table(SysRoleResource.EntityNode.class)
public class SysRoleResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer roleId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer resourceId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer domainId;
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
    public Integer getRoleId(){
    	return this.roleId;
    }
    public void setRoleId(Integer roleId){
    	this.roleId = roleId;
    }
    public Integer getResourceId(){
    	return this.resourceId;
    }
    public void setResourceId(Integer resourceId){
    	this.resourceId = resourceId;
    }
    public Integer getDomainId(){
    	return this.domainId;
    }
    public void setDomainId(Integer domainId){
    	this.domainId = domainId;
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

    public static class EntityNode extends AbstractEntityNode<SysRoleResource> {
        public static final EntityNode INSTANCE = new EntityNode("tsrr");;
    	/** 主键 */
        public FieldNode<SysRoleResource, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysRoleResource, Integer> roleId =  createFieldNode("roleId","role_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysRoleResource, Integer> resourceId =  createFieldNode("resourceId","resource_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysRoleResource, Integer> domainId =  createFieldNode("domainId","domain_id",Integer.class,JdbcType.INTEGER);
    	/** 创建人 */
        public FieldNode<SysRoleResource, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysRoleResource, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysRoleResource, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysRoleResource, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysRoleResource.class,"t_sys_role_resource",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysRoleResource> {
		
	}
	
    // ==== 自定义属性 ====
}