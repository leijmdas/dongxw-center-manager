package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.util.Date;
/**
 * SysShortlink
 * @author generator
 * @date 2018年10月11日
 */
public class SysShortlinkDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	private Integer id;
	/**
	  * 编码
	  * nullable:false,length:12
	  */
	private String code;
	/**
	  * 名称
	  * nullable:false,length:128
	  */
	private String name;
	/**
	  * 地址
	  * nullable:false,length:250
	  */
	private String url;
	
	/**
	 * 短链接地址
	 */
	private String shortUrl;
	/**
	  * 状态
	  * nullable:false,length:11
	  */
	private Integer status;
	/**
	  * 备注
	  * nullable:true,length:500
	  */
	private String remark;
	/**
	  * 
	  * nullable:false,length:19
	  */
	private Date createOn;
	/**
	  * 
	  * nullable:false,length:19
	  */
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
}