package cn.kunlong.center.biz.sys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.mybatis.hbatis.core.AbstractEntityNode;
import org.mybatis.hbatis.core.FieldNode;
import org.mybatis.hbatis.core.annotation.Column;
import org.mybatis.hbatis.core.annotation.Table;
import org.mybatis.hbatis.core.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * SysNotice
 * @author generator
 * @date 2015年12月17日
 */
@Table(SysNotice.EntityNode.class)
public class SysNotice  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 公告标题
	  * nullable:false,length:32
	  */
	@Column(comment = "公告标题")	
	@NotNull
	private String titile;
	/**
	  * 公告内容
	  * nullable:false,length:715,827,882
	  */
	@Column(comment = "公告内容")	
	@NotNull
	private String content;
	/**
	  * 公告展示顺序
	  * nullable:false,length:8
	  */
	@Column(comment = "公告展示顺序")	
	@NotNull
	private Integer showSeq;
	/**
	  * 修改时间
	  * nullable:false,length:19
	  */
	@Column(comment = "修改时间")	
	@NotNull
	private Date updateTime;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createTime;
	/**
	  * 开始时间
	  * nullable:true,length:10
	  */
	
	@Column(comment = "开始时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date beginDate;
	/**
	  * 结束时间
	  * nullable:true,length:10
	  */
	@Column(comment = "结束时间")	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	/**
	  * 公告类别
	  * nullable:true,length:2
	  */
	@Column(comment = "公告类别")	
	private String noticeType;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:1
	  */
	@Column(comment = "状态(1:启用;0:停用)")	
	@NotNull
	private String noticeStatus;
	/**
	  * 创建人
	  * nullable:true,length:11
	  */
	@Column(comment = "创建人")	
	private Integer opBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getTitile(){
    	return this.titile;
    }
    public void setTitile(String titile){
    	this.titile = titile;
    }
    public String getContent(){
    	return this.content;
    }
    public void setContent(String content){
    	this.content = content;
    }
    public Integer getShowSeq(){
    	return this.showSeq;
    }
    public void setShowSeq(Integer showSeq){
    	this.showSeq = showSeq;
    }
    public Date getUpdateTime(){
    	return this.updateTime;
    }
    public void setUpdateTime(Date updateTime){
    	this.updateTime = updateTime;
    }
    public Date getCreateTime(){
    	return this.createTime;
    }
    public void setCreateTime(Date createTime){
    	this.createTime = createTime;
    }
    public Date getBeginDate(){
    	return this.beginDate;
    }
    public void setBeginDate(Date beginDate){
    	this.beginDate = beginDate;
    }
    public Date getEndDate(){
    	return this.endDate;
    }
    public void setEndDate(Date endDate){
    	this.endDate = endDate;
    }
    public String getNoticeType(){
    	return this.noticeType;
    }
    public void setNoticeType(String noticeType){
    	this.noticeType = noticeType;
    }
    public String getNoticeStatus(){
    	return this.noticeStatus;
    }
    public void setNoticeStatus(String noticeStatus){
    	this.noticeStatus = noticeStatus;
    }
    public Integer getOpBy(){
    	return this.opBy;
    }
    public void setOpBy(Integer opBy){
    	this.opBy = opBy;
    }

    public static class EntityNode extends AbstractEntityNode<SysNotice> {
        public static final EntityNode INSTANCE = new EntityNode("tsn");;
    	/** 主键 */
        public FieldNode<SysNotice, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 公告标题 */
        public FieldNode<SysNotice, String> titile =  createFieldNode("titile","titile",String.class,JdbcType.VARCHAR);
    	/** 公告内容 */
        public FieldNode<SysNotice, String> content =  createFieldNode("content","content",String.class,JdbcType.LONGVARCHAR);
    	/** 公告展示顺序 */
        public FieldNode<SysNotice, Integer> showSeq =  createFieldNode("showSeq","show_seq",Integer.class,JdbcType.INTEGER);
    	/** 修改时间 */
        public FieldNode<SysNotice, Date> updateTime =  createFieldNode("updateTime","update_time",Date.class,JdbcType.TIMESTAMP);
    	/** 创建时间 */
        public FieldNode<SysNotice, Date> createTime =  createFieldNode("createTime","create_time",Date.class,JdbcType.TIMESTAMP);
    	/** 开始时间 */
        public FieldNode<SysNotice, Date> beginDate =  createFieldNode("beginDate","begin_date",Date.class,JdbcType.DATE);
    	/** 结束时间 */
        public FieldNode<SysNotice, Date> endDate =  createFieldNode("endDate","end_date",Date.class,JdbcType.DATE);
    	/** 公告类别 */
        public FieldNode<SysNotice, String> noticeType =  createFieldNode("noticeType","notice_type",String.class,JdbcType.CHAR);
    	/** 状态(1:启用;0:停用) */
        public FieldNode<SysNotice, String> noticeStatus =  createFieldNode("noticeStatus","notice_status",String.class,JdbcType.CHAR);
    	/** 创建人 */
        public FieldNode<SysNotice, Integer> opBy =  createFieldNode("opBy","op_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SysNotice.class,"t_sys_notice",alias);
        }
    }
    // ==== 自定义属性 ====
}