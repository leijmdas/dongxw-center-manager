package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * SysHttpJob 
 * @author generator
 * @date 2019年03月21日
 */
@Table(SysHttpJob.EntityNode.class)
public class SysHttpJob implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer groupId;
	/**
	  * 
	  * nullable:false,length:128
	  */
	@Column(comment = "")	
	@NotNull
	private String name;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@Column(comment = "")	
	private String expression;
	/**
	  * 
	  * nullable:false,length:256
	  */
	@Column(comment = "")	
	@NotNull
	private String url;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer status;
	/**
	  * 
	  * nullable:true,length:500
	  */
	@Column(comment = "")	
	private String remark;
	/**
	  * 
	  * nullable:false,length:19
	  */
	@Column(comment = "")	
	@NotNull
	private Date createOn;
	/**
	  * 
	  * nullable:false,length:19
	  */
	@Column(comment = "")	
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getGroupId(){
    	return this.groupId;
    }
    public void setGroupId(Integer groupId){
    	this.groupId = groupId;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getExpression(){
    	return this.expression;
    }
    public void setExpression(String expression){
    	this.expression = expression;
    }
    public String getUrl(){
    	return this.url;
    }
    public void setUrl(String url){
    	this.url = url;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Date getCreateOn(){
    	return this.createOn;
    }
    public void setCreateOn(Date createOn){
    	this.createOn = createOn;
    }
    public Date getOpOn(){
    	return this.opOn;
    }
    public void setOpOn(Date opOn){
    	this.opOn = opOn;
    }

    public static class EntityNode extends AbstractEntityNode<SysHttpJob> {
        public static final EntityNode INSTANCE = new EntityNode("tshj");;
    	/**  */
        public FieldNode<SysHttpJob, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysHttpJob, Integer> groupId =  createFieldNode("groupId","group_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysHttpJob, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysHttpJob, String> expression =  createFieldNode("expression","expression",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysHttpJob, String> url =  createFieldNode("url","url",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysHttpJob, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysHttpJob, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysHttpJob, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/**  */
        public FieldNode<SysHttpJob, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysHttpJob.class,"t_sys_http_job",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<SysHttpJob> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<SysHttpJob>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
	private SysJobGroup sysJobGroup;
	public SysJobGroup getSysJobGroup() {
		return sysJobGroup;
	}
	public void setSysJobGroup(SysJobGroup sysJobGroup) {
		this.sysJobGroup = sysJobGroup;
	}
	
}