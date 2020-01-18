package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
/**
 * SysDomain
 * @author generator
 * @date 2016年05月04日
 */
@Table(SysDomain.EntityNode.class)
public class SysDomain  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 编码
	  * nullable:false,length:50
	  */
	@Column(comment = "编码")	
	@NotNull
	private String domainCode;
	/**
	  * 名称
	  * nullable:false,length:250
	  */
	@Column(comment = "名称")	
	@NotNull
	private String domainName;
	/**
	  * api密码
	  * nullable:false,length:250
	  */
	@Column(comment = "api密码")	
	@NotNull
	private String apiSecret;
	/**
	  * 地址
	  * nullable:false,length:250
	  */
	@Column(comment = "地址")	
	@NotNull
	private String domainUrl;
	/**
	  * 状态
	  * nullable:false,length:4
	  */
	@Column(comment = "状态")	
	@NotNull
	private Byte status;
	/**
	  * 备注
	  * nullable:false,length:500
	  */
	@Column(comment = "备注")	
	@NotNull
	private String remark;
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
    public String getDomainCode(){
    	return this.domainCode;
    }
    public void setDomainCode(String domainCode){
    	this.domainCode = domainCode;
    }
    public String getDomainName(){
    	return this.domainName;
    }
    public void setDomainName(String domainName){
    	this.domainName = domainName;
    }
    public String getApiSecret(){
    	return this.apiSecret;
    }
    public void setApiSecret(String apiSecret){
    	this.apiSecret = apiSecret;
    }
    public String getDomainUrl(){
    	return this.domainUrl;
    }
    public void setDomainUrl(String domainUrl){
    	this.domainUrl = domainUrl;
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

    public static class EntityNode extends AbstractEntityNode<SysDomain> {
        public static final EntityNode INSTANCE = new EntityNode("tsd");;
    	/**  */
        public FieldNode<SysDomain, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 编码 */
        public FieldNode<SysDomain, String> domainCode =  createFieldNode("domainCode","domain_code",String.class,JdbcType.VARCHAR);
    	/** 名称 */
        public FieldNode<SysDomain, String> domainName =  createFieldNode("domainName","domain_name",String.class,JdbcType.VARCHAR);
    	/** api密码 */
        public FieldNode<SysDomain, String> apiSecret =  createFieldNode("apiSecret","api_secret",String.class,JdbcType.VARCHAR);
    	/** 地址 */
        public FieldNode<SysDomain, String> domainUrl =  createFieldNode("domainUrl","domain_url",String.class,JdbcType.VARCHAR);
    	/** 状态 */
        public FieldNode<SysDomain, Byte> status =  createFieldNode("status","status",Byte.class,JdbcType.TINYINT);
    	/** 备注 */
        public FieldNode<SysDomain, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 操作人 */
        public FieldNode<SysDomain, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysDomain, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysDomain.class,"t_sys_domain",alias);
        }
    }
    // ==== 自定义属性 ====
}