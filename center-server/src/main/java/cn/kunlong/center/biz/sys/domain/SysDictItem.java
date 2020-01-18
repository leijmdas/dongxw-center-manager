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
 * SysDictDetail
 * @author generator
 * @date 2015年12月15日
 */
@Table(SysDictItem.EntityNode.class)
public class SysDictItem  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 字典id
	  * nullable:false,length:11
	  */
	@Column(comment = "字典id")	
	@NotNull
	private Integer dictId;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@Column(comment = "")	
	@NotNull
	private String code;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:128
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private String name;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private Byte status;
	/**
	  * order_num
	  * nullable:false,length:11
	  */
	@Column(comment = "order_num")	
	@NotNull
	private Integer orderNum;
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
    public Integer getDictId(){
    	return this.dictId;
    }
    public void setDictId(Integer dictId){
    	this.dictId = dictId;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public Byte getStatus(){
    	return this.status;
    }
    public void setStatus(Byte status){
    	this.status = status;
    }
    public Integer getOrderNum(){
    	return this.orderNum;
    }
    public void setOrderNum(Integer orderNum){
    	this.orderNum = orderNum;
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

    public static class EntityNode extends AbstractEntityNode<SysDictItem> {
        public static final EntityNode INSTANCE = new EntityNode("tsdd");;
    	/**  */
        public FieldNode<SysDictItem, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 字典id */
        public FieldNode<SysDictItem, Integer> dictId =  createFieldNode("dictId","dict_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysDictItem, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysDictItem, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysDictItem, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** order_num */
        public FieldNode<SysDictItem, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	/** 备注 */
        public FieldNode<SysDictItem, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysDictItem, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysDictItem, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysDictItem, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysDictItem, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysDictItem.class,"t_sys_dict_item",alias);
        }
    }
    // ==== 自定义属性 ====
    
    private SysDict sysDict;
	public SysDict getSysDict() {
		return sysDict;
	}
	public void setSysDict(SysDict sysDict) {
		this.sysDict = sysDict;
	}
}
    