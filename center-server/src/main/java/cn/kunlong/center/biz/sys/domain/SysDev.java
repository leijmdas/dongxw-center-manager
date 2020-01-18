package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysDev
 * @author generator
 * @date 2016年02月18日
 */
@Table(SysDev.EntityNode.class)
public class SysDev  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 原子值
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "原子值")	
	private Integer id;
	/**
	  * 名称
	  * nullable:false,length:128
	  */
	@Column(comment = "名称")	
	@NotNull
	private String devName;
	/**
	  * 键
	  * nullable:false,length:64
	  */
	@Column(comment = "键")	
	@NotNull
	private String devKey;
	/**
	  * 值
	  * nullable:false,length:128
	  */
	@Column(comment = "值")	
	@NotNull
	private String devValue;
	/**
	  * 类型，日int，string，date
	  * nullable:true,length:8
	  */
	@Column(comment = "类型，日int，string，date")	
	private String devValueType;
	/**
	  * 详细描述
	  * nullable:true,length:256
	  */
	@Column(comment = "详细描述")	
	private String remark;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getDevName(){
    	return this.devName;
    }
    public void setDevName(String devName){
    	this.devName = devName;
    }
    public String getDevKey(){
    	return this.devKey;
    }
    public void setDevKey(String devKey){
    	this.devKey = devKey;
    }
    public String getDevValue(){
    	return this.devValue;
    }
    public void setDevValue(String devValue){
    	this.devValue = devValue;
    }
    public String getDevValueType(){
    	return this.devValueType;
    }
    public void setDevValueType(String devValueType){
    	this.devValueType = devValueType;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }

    public static class EntityNode extends AbstractEntityNode<SysDev> {
        public static final EntityNode INSTANCE = new EntityNode("tsd");;
    	/** 原子值 */
        public FieldNode<SysDev, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysDev, String> devName =  createFieldNode("devName","dev_name",String.class,JdbcType.VARCHAR);
    	/** 键 */
        public FieldNode<SysDev, String> devKey =  createFieldNode("devKey","dev_key",String.class,JdbcType.VARCHAR);
    	/** 值 */
        public FieldNode<SysDev, String> devValue =  createFieldNode("devValue","dev_value",String.class,JdbcType.VARCHAR);
    	/** 类型，日int，string，date */
        public FieldNode<SysDev, String> devValueType =  createFieldNode("devValueType","dev_value_type",String.class,JdbcType.VARCHAR);
    	/** 详细描述 */
        public FieldNode<SysDev, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysDev.class,"t_sys_dev",alias);
        }
    }
    // ==== 自定义属性 ====
}