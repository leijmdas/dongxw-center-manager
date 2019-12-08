package cn.integriti.center.core.enums;


public enum StatusEnum {
	ENABLE("启用",(byte)1),DISABLE("停用",(byte)0);
	String name;
	Byte value;
	private StatusEnum(String name,byte value){
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public Byte getValue() {
		return value;
	}
	
}
