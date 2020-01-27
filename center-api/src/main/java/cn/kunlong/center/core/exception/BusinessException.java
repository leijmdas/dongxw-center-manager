package cn.kunlong.center.core.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String msg;

	public BusinessException(String code,String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
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
