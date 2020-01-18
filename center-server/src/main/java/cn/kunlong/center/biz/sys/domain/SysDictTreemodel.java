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
 * SysDictTreemodel
 * @author generator
 * @date 2015年12月27日
 */
@Table(SysDictTreemodel.EntityNode.class)
public class SysDictTreemodel  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 名称
	  * nullable:false,length:64
	  */
	@Column(comment = "名称")	
	@NotNull
	private String name;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(comment = "")	
	private Integer pid;
	/**
	  * 编码
	  * nullable:false,length:4
	  */
	@Column(comment = "编码")	
	@NotNull
	private String code;
	/**
	  * 位置类别（1：科室；2：具体位置）
	  * nullable:false,length:128
	  */
	@Column(comment = "路径")	
	@NotNull
	private String path;
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
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public Integer getPid(){
    	return this.pid;
    }
    public void setPid(Integer pid){
    	this.pid = pid;
    }
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPath(){
    	return this.path;
    }
    public void setPath(String path){
    	this.path = path;
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

    public static class EntityNode extends AbstractEntityNode<SysDictTreemodel> {
        public static final EntityNode INSTANCE = new EntityNode("thel");;
    	/**  */
        public FieldNode<SysDictTreemodel, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 名称 */
        public FieldNode<SysDictTreemodel, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysDictTreemodel, Integer> pid =  createFieldNode("pid","pid",Integer.class,JdbcType.INTEGER);
    	/** 位置类别（1：科室；2：具体位置） */
        public FieldNode<SysDictTreemodel, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 位置类别（1：科室；2：具体位置） */
        public FieldNode<SysDictTreemodel, String> path =  createFieldNode("path","path",String.class,JdbcType.VARCHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysDictTreemodel, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** order_num */
        public FieldNode<SysDictTreemodel, Integer> orderNum =  createFieldNode("orderNum","order_num",Integer.class,JdbcType.INTEGER);
    	/** 备注 */
        public FieldNode<SysDictTreemodel, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<SysDictTreemodel, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<SysDictTreemodel, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 操作人 */
        public FieldNode<SysDictTreemodel, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysDictTreemodel, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysDictTreemodel.class,"t_sys_dict_treemodel",alias);
        }
    }
    // ==== 自定义属性 ====

    private SysDictTreemodel parentSysDictTreemodel;
    
	public SysDictTreemodel getParentSysDictTreemodel() {
		return parentSysDictTreemodel;
	}
	public void setParentSysDictTreemodel(SysDictTreemodel location) {
		this.parentSysDictTreemodel = location;
	}
}