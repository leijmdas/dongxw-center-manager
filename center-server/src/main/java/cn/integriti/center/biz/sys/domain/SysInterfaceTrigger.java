package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysInterfaceTrigger
 * @author generator
 * @date 2016年06月06日
 */
@Table(SysInterfaceTrigger.EntityNode.class)
public class SysInterfaceTrigger  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 接口id
	  * nullable:true,length:11
	  */
	@Column(comment = "接口id")	
	private Integer interfaceId;
	/**
	  * 触发器id
	  * nullable:true,length:11
	  */
	@Column(comment = "触发器id")	
	private Integer triggerId;
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
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getInterfaceId(){
    	return this.interfaceId;
    }
    public void setInterfaceId(Integer interfaceId){
    	this.interfaceId = interfaceId;
    }
    public Integer getTriggerId(){
    	return this.triggerId;
    }
    public void setTriggerId(Integer triggerId){
    	this.triggerId = triggerId;
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

    public static class EntityNode extends AbstractEntityNode<SysInterfaceTrigger> {
        public static final EntityNode INSTANCE = new EntityNode("tsit");;
    	/**  */
        public FieldNode<SysInterfaceTrigger, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 接口id */
        public FieldNode<SysInterfaceTrigger, Integer> interfaceId =  createFieldNode("interfaceId","interface_id",Integer.class,JdbcType.INTEGER);
    	/** 触发器id */
        public FieldNode<SysInterfaceTrigger, Integer> triggerId =  createFieldNode("triggerId","trigger_id",Integer.class,JdbcType.INTEGER);
    	/** 创建人 */
        public FieldNode<SysInterfaceTrigger, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysInterfaceTrigger, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysInterfaceTrigger, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysInterfaceTrigger, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysInterfaceTrigger.class,"t_sys_interface_trigger",alias);
        }
    }
    // ==== 自定义属性 ====
}