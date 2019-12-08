package cn.integriti.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
/**
 * SysMsg
 * @author generator
 * @date 2016年02月18日
 */
@Table(SysMsg.EntityNode.class)
public class SysMsg  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * id
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "id")	
	private Integer id;
	/**
	  * 消息类型(1: PC,2: 邮件)
	  * nullable:true,length:4
	  */
	@Column(comment = "消息类型(1: PC,2: 邮件)")	
	private Byte msgType;
	/**
	  * 标题
	  * nullable:true,length:128
	  */
	@Column(comment = "标题")	
	private String title;
	/**
	  * 内容
	  * nullable:true,length:21,845
	  */
	@Column(comment = "内容")	
	private String content;
	/**
	  * 接收者
	  * nullable:true,length:11
	  */
	@Column(comment = "接收者")	
	private Integer receiverId;
	/**
	  * 接收邮箱
	  * nullable:true,length:128
	  */
	@Column(comment = "接收邮箱")	
	private String receiverEmail;
	/**
	  * 是否已读
	  * nullable:true,length:1
	  */
	@Column(comment = "是否已读")	
	private Boolean isRead;
	/**
	  * 读取时间
	  * nullable:true,length:19
	  */
	@Column(comment = "读取时间")	
	private Date readOn;
	/**
	  * 发送状态
	  * nullable:true,length:4
	  */
	@Column(comment = "发送状态")	
	private Byte sendStatus;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createOn;
	/**
	  * 更新时间
	  * nullable:false,length:19
	  */
	@Column(comment = "更新时间")	
	@NotNull
	private Date opOn;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Byte getMsgType(){
    	return this.msgType;
    }
    public void setMsgType(Byte msgType){
    	this.msgType = msgType;
    }
    public String getTitle(){
    	return this.title;
    }
    public void setTitle(String title){
    	this.title = title;
    }
    public String getContent(){
    	return this.content;
    }
    public void setContent(String content){
    	this.content = content;
    }
    public Integer getReceiverId(){
    	return this.receiverId;
    }
    public void setReceiverId(Integer receiverId){
    	this.receiverId = receiverId;
    }
    public String getReceiverEmail(){
    	return this.receiverEmail;
    }
    public void setReceiverEmail(String receiverEmail){
    	this.receiverEmail = receiverEmail;
    }
    public Boolean getIsRead(){
    	return this.isRead;
    }
    public void setIsRead(Boolean isRead){
    	this.isRead = isRead;
    }
    public Date getReadOn(){
    	return this.readOn;
    }
    public void setReadOn(Date readOn){
    	this.readOn = readOn;
    }
    public Byte getSendStatus(){
    	return this.sendStatus;
    }
    public void setSendStatus(Byte sendStatus){
    	this.sendStatus = sendStatus;
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

    public static class EntityNode extends AbstractEntityNode<SysMsg> {
        public static final EntityNode INSTANCE = new EntityNode("tsm");;
    	/** id */
        public FieldNode<SysMsg, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 消息类型(1: PC,2: 邮件) */
        public FieldNode<SysMsg, Byte> msgType =  createFieldNode("msgType","msg_type",Byte.class,JdbcType.TINYINT);
    	/** 标题 */
        public FieldNode<SysMsg, String> title =  createFieldNode("title","title",String.class,JdbcType.VARCHAR);
    	/** 内容 */
        public FieldNode<SysMsg, String> content =  createFieldNode("content","content",String.class,JdbcType.LONGVARCHAR);
    	/** 接收者 */
        public FieldNode<SysMsg, Integer> receiverId =  createFieldNode("receiverId","receiver_id",Integer.class,JdbcType.INTEGER);
    	/** 接收邮箱 */
        public FieldNode<SysMsg, String> receiverEmail =  createFieldNode("receiverEmail","receiver_email",String.class,JdbcType.VARCHAR);
    	/** 是否已读 */
        public FieldNode<SysMsg, Boolean> isRead =  createFieldNode("isRead","is_read",Boolean.class,JdbcType.BIT);
    	/** 读取时间 */
        public FieldNode<SysMsg, Date> readOn =  createFieldNode("readOn","read_on",Date.class,JdbcType.TIMESTAMP);
    	/** 发送状态 */
        public FieldNode<SysMsg, Byte> sendStatus =  createFieldNode("sendStatus","send_status",Byte.class,JdbcType.TINYINT);
    	/** 创建时间 */
        public FieldNode<SysMsg, Date> createOn =  createFieldNode("createOn","create_on",Date.class,JdbcType.TIMESTAMP);
    	/** 更新时间 */
        public FieldNode<SysMsg, Date> opOn =  createFieldNode("opOn","op_on",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysMsg.class,"t_sys_msg",alias);
        }
    }
    // ==== 自定义属性 ====
}