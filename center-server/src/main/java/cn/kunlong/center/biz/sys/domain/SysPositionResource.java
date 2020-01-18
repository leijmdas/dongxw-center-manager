package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysRoleResource
 * @author generator
 * @date 2015年12月05日
 */
@Table(SysPositionResource.EntityNode.class)
public class SysPositionResource  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "主键",autoIncrement=true)	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer positionId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer resourceId;
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
    
    public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getResourceId(){
    	return this.resourceId;
    }
    public void setResourceId(Integer resourceId){
    	this.resourceId = resourceId;
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

    public static class EntityNode extends AbstractEntityNode<SysPositionResource> {
        public static final EntityNode INSTANCE = new EntityNode("tsrr");;
    	/** 主键 */
        public FieldNode<SysPositionResource, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysPositionResource, Integer> positionId =  createFieldNode("positionId","position_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysPositionResource, Integer> resourceId =  createFieldNode("resourceId","resource_id",Integer.class,JdbcType.INTEGER);
    	/** 创建人 */
        public FieldNode<SysPositionResource, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysPositionResource, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysPositionResource, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysPositionResource, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysPositionResource.class,"t_sys_position_resource",alias);
        }
    }
    // ==== 自定义属性 ====
}