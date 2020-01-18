package cn.kunlong.center.core.enums;


public enum RequestContextKeyEnum {
	CORP_ID("企业ID","log.corpId");
	String name;
	String value;
	private RequestContextKeyEnum(String name,String value){
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	
}
