package cn.kunlong.center.core.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public BusinessException(String code,String msg) {
		super(msg);
		this.code = code;
	}
	
	public BusinessException(String msg) {
		super(msg);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
