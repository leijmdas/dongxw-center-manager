package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;

import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
/**
 * SysInterfaceParam
 * @author generator
 * @date 2016年06月06日
 */
@Table(SysInterfaceParam.EntityNode.class)
public class SysInterfaceParam  implements Serializable {
	
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
	  * 参数名
	  * nullable:true,length:64
	  */
	@Column(comment = "参数名")	
	private String paramKey;
	/**
	  * 参数值
	  * nullable:true,length:255
	  */
	@Column(comment = "参数值")	
	private String paramVal;
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
    public String getParamKey(){
    	return this.paramKey;
    }
    public void setParamKey(String paramKey){
    	this.paramKey = paramKey;
    }
    public String getParamVal(){
    	return this.paramVal;
    }
    public void setParamVal(String paramVal){
    	this.paramVal = paramVal;
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

    public static class EntityNode extends AbstractEntityNode<SysInterfaceParam> {
        public static final EntityNode INSTANCE = new EntityNode("tsip");;
    	/**  */
        public FieldNode<SysInterfaceParam, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 接口id */
        public FieldNode<SysInterfaceParam, Integer> interfaceId =  createFieldNode("interfaceId","interface_id",Integer.class,JdbcType.INTEGER);
    	/** 参数名 */
        public FieldNode<SysInterfaceParam, String> paramKey =  createFieldNode("paramKey","param_key",String.class,JdbcType.VARCHAR);
    	/** 参数值 */
        public FieldNode<SysInterfaceParam, String> paramVal =  createFieldNode("paramVal","param_val",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysInterfaceParam, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysInterfaceParam, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新人 */
        public FieldNode<SysInterfaceParam, Integer> updateBy =  createFieldNode("updateBy","update_by",Integer.class,JdbcType.INTEGER);
    	/** 更新时间 */
        public FieldNode<SysInterfaceParam, Date> updateOn =  createFieldNode("updateOn","update_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysInterfaceParam.class,"t_sys_interface_param",alias);
        }
    }
    // ==== 自定义属性 ====
}