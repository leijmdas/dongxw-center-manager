package cn.integriti.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysDict
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysDict")
public class SysDictDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	
	private Integer corpId;
	/**
	  * 分类名称
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "分类名称",required = true,notes = "分类名称 ")
	private String dictName;
	/**
	  * 编码
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "编码",required = true,notes = "编码 ")
	private String dictCode;
	/**
	  * 类型(1:普通字典,2:科目字典)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "类型(1:普通字典,2:科目字典)",required = true,notes = "类型(1:普通字典,2:科目字典) ")
	private Byte dictType;
	/**
	  * 状态(1:启用;0:停用)
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态(1:启用;0:停用)",required = true,notes = "状态(1:启用;0:停用) ")
	private Byte status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	@ApiModelProperty(value = "备注",required = false,notes = "备注 ")
	private String remark;
	/**
	  * 创建人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "创建人",required = true,notes = "创建人 ")
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "创建时间",required = true,notes = "创建时间 ")
	private Date createOn;
	/**
	  * 操作人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "操作人",required = true,notes = "操作人 ")
	private Integer opBy;
	/**
	  * 操作时间
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "操作时间",required = true,notes = "操作时间 ")
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
    public Byte getDictType(){
    	return this.dictType;
    }
    public void setDictType(Byte dictType){
    	this.dictType = dictType;
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
	public Integer getCorpId() {
		return corpId;
	}
	public void setCorpId(Integer corpId) {
		this.corpId = corpId;
	}
    
    // ==== 自定义属性 ====
	
	private List<SysDictItemDTO> items;
	public List<SysDictItemDTO> getItems() {
		return items;
	}
	public void setItems(List<SysDictItemDTO> items) {
		this.items = items;
	}
	
}