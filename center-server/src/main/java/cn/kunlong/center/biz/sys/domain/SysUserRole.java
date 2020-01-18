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
 * SysUserRole
 * @author generator
 * @date 2015年12月05日
 */
@Table(SysUserRole.EntityNode.class)
public class SysUserRole  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,comment = "主键",autoIncrement=true)	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer roleId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer userId;
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
    public Integer getRoleId(){
    	return this.roleId;
    }
    public void setRoleId(Integer roleId){
    	this.roleId = roleId;
    }
    public Integer getUserId(){
    	return this.userId;
    }
    public void setUserId(Integer userId){
    	this.userId = userId;
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

    public static class EntityNode extends AbstractEntityNode<SysUserRole> {
        public static final EntityNode INSTANCE = new EntityNode("tsur");;
    	/** 主键 */
        public FieldNode<SysUserRole, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysUserRole, Integer> roleId =  createFieldNode("roleId","role_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<SysUserRole, Integer> userId =  createFieldNode("userId","user_id",Integer.class,JdbcType.INTEGER);
    	/** 操作人 */
        public FieldNode<SysUserRole, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
    	/** 操作时间 */
        public FieldNode<SysUserRole, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysUserRole.class,"t_sys_user_role",alias);
        }
    }
    // ==== 自定义属性 ====
	public static class QueryParam extends org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam<SysUserRole> {
		private Integer roleType;

		public Integer getRoleType() {
			return roleType;
		}

		public void setRoleType(Integer roleType) {
			this.roleType = roleType;
		}

	}
}