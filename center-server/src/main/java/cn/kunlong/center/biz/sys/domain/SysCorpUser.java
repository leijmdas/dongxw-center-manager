package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.util.Date;
/**
 * SysCorpUser
 * @author generator
 * @date 2018年06月07日
 */
@Table(SysCorpUser.EntityNode.class)
public class SysCorpUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 用户Id
	  * nullable:false,length:11
	  */
	@Column(comment = "用户Id")	
	@NotNull
	private Integer userId;
	/**
	  * 组织结构id
	  * nullable:false,length:11
	  */
	@Column(comment = "组织结构id")	
	@NotNull
	private Integer orgId;
	/**
	  * 企业id
	  * nullable:false,length:11
	  */
	@Column(comment = "企业id")	
	@NotNull
	private Integer corpId;
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
    public Integer getUserId(){
    	return this.userId;
    }
    public void setUserId(Integer userId){
    	this.userId = userId;
    }
    public Integer getOrgId(){
    	return this.orgId;
    }
    public void setOrgId(Integer orgId){
    	this.orgId = orgId;
    }
    public Integer getCorpId(){
    	return this.corpId;
    }
    public void setCorpId(Integer corpId){
    	this.corpId = corpId;
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

    public static class EntityNode extends AbstractEntityNode<SysCorpUser> {
        public static final EntityNode INSTANCE = new EntityNode("tscu");;
    	/**  */
        public FieldNode<SysCorpUser, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 用户Id */
        public FieldNode<SysCorpUser, Integer> userId =  createFieldNode("userId","user_id",Integer.class,JdbcType.INTEGER);
    	/** 组织结构id */
        public FieldNode<SysCorpUser, Integer> orgId =  createFieldNode("orgId","org_id",Integer.class,JdbcType.INTEGER);
    	/** 企业id */
        public FieldNode<SysCorpUser, Integer> corpId =  createFieldNode("corpId","corp_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysCorpUser, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/**  */
        public FieldNode<SysCorpUser, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysCorpUser.class,"t_sys_corp_user",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysCorpUser> {
		
	}
	
    // ==== 自定义属性 ====
}