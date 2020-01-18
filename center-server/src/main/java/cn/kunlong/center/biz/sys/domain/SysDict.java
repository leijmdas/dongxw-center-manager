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
 * SysDict
 * @author generator
 * @date 2015年12月15日
 */
@Table(SysDict.EntityNode.class)
public class SysDict  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	
	private Integer corpId;
	/**
	  * 分类名称
	  * nullable:false,length:64
	  */
	@Column(comment = "分类名称")	
	@NotNull
	private String dictName;
	/**
	  * 编码
	  * nullable:false,length:64
	  */
	@Column(comment = "编码")	
	@NotNull
	private String dictCode;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private Byte status;
	
	@Column(comment = "类型(1:普通字典,2:科目字典)")	
	@NotNull
	private Byte dictType;
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
    public String getDictName(){
    	return this.dictName;
    }
    public void setDictName(String dictName){
    	this.dictName = dictName;
    }
    public String getDictCode(){
    	return this.dictCode;
    }
    public void setDictCode(String dictCode){
    	this.dictCode = dictCode;
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

    public Byte getDictType() {
		return dictType;
	}
	public void setDictType(Byte dictType) {
		this.dictType = dictType;
	}

	public Integer getCorpId() {
		return corpId;
	}
	public void setCorpId(Integer corpId) {
		this.corpId = corpId;
	}

	public static class EntityNode extends AbstractEntityNode<SysDict> {
        public static final EntityNode INSTANCE = new EntityNode("tsd");;
    	/**  */
        public FieldNode<SysDict, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
        public FieldNode<SysDict, Integer> corpId =  createFieldNode("corpId","corp_id",Integer.class,JdbcType.INTEGER);
    	/** 分类名称 */
        public FieldNode<SysDict, String> dictName =  createFieldNode("dictName","dict_name",String.class,JdbcType.VARCHAR);
    	/** 编码 */
        public FieldNode<SysDict, String> dictCode =  createFieldNode("dictCode","dict_code",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysDict, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
        public FieldNode<SysDict, Byte> dictType =  createFieldNode("dictType","dict_type",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysDict, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysDict, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysDict, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysDict, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysDict, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysDict.class,"t_sys_dict",alias);
        }
    }
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysDict> {
	}
    // ==== 自定义属性 ====
    
    private List<SysDictItem>  items;
	public List<SysDictItem> getItems() {
		return items;
	}
	public void setItems(List<SysDictItem> items) {
		this.items = items;
	}
	
    
}