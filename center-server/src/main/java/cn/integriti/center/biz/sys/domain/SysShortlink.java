package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
/**
 * SysShortlink
 * @author generator
 * @date 2018年10月11日
 */
@Table(SysShortlink.EntityNode.class)
public class SysShortlink implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 编码
	  * nullable:false,length:12
	  */
	@Column(comment = "编码")	
	@NotNull
	private String code;
	/**
	  * 名称
	  * nullable:false,length:128
	  */
	@Column(comment = "名称")	
	@NotNull
	private String name;
	/**
	  * 地址
	  * nullable:false,length:250
	  */
	@Column(comment = "地址")	
	@NotNull
	private String url;
	
	@Column(comment = "短链地址")	
	private String shortUrl;
	/**
	  * 状态
	  * nullable:false,length:11
	  */
	@Column(comment = "状态")	
	@NotNull
	private Integer status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@Column(comment = "备注")	
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
	@NotNull
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
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

    public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public static class EntityNode extends AbstractEntityNode<SysShortlink> {
        public static final EntityNode INSTANCE = new EntityNode("tss");;
    	/**  */
        public FieldNode<SysShortlink, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 编码 */
        public FieldNode<SysShortlink, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 名称 */
        public FieldNode<SysShortlink, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/** 地址 */
        public FieldNode<SysShortlink, String> url =  createFieldNode("url","url",String.class,JdbcType.VARCHAR);
        public FieldNode<SysShortlink, String> shortUrl =  createFieldNode("shortUrl","short_url",String.class,JdbcType.VARCHAR);
    	/** 状态 */
        public FieldNode<SysShortlink, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 备注 */
        public FieldNode<SysShortlink, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<SysShortlink, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/**  */
        public FieldNode<SysShortlink, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysShortlink.class,"t_sys_shortlink",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysShortlink> {
		
	}
	
    // ==== 自定义属性 ====
}