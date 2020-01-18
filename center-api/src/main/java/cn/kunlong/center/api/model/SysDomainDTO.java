package cn.kunlong.center.api.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.lang.Byte;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * SysDomain
 * @author generator
 * @date 2018年06月10日
 */
@ApiModel(value="SysDomain")
public class SysDomainDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String domainCode;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String domainName;
	/**
	  * 
	  * nullable:false,length:250
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String domainUrl;
	/**
	  * 
	  * nullable:false,length:100
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String apiSecret;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Byte status;
	/**
	  * 
	  * nullable:true,length:500
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String remark;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer opBy;
	/**
	  * 
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
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
    public String getDomainUrl(){
    	return this.domainUrl;
    }
    public void setDomainUrl(String domainUrl){
    	this.domainUrl = domainUrl;
    }
    public String getApiSecret(){
    	return this.apiSecret;
    }
    public void setApiSecret(String apiSecret){
    	this.apiSecret = apiSecret;
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
    // ==== 自定义属性 ====
}