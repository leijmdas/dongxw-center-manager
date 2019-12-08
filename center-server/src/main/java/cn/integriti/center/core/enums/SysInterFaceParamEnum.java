package cn.integriti.center.core.enums;

public enum SysInterFaceParamEnum {
	
	REQUESTMETHOD_GET((byte)1, "GET"),
	REQUESTMETHOD_POST((byte)2, "POST");
	
	private Byte key;

	private String value;

	private SysInterFaceParamEnum(Byte key, String value) {
		this.key = key;
		this.value = value;
	}

	public Byte getKey() {
		return key;
	}

	public void setKey(Byte key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
