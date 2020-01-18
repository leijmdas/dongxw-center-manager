package cn.kunlong.center.biz.listener;

import org.springframework.context.ApplicationEvent;

public class JobExceptionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public String code = null;
	public JobExceptionEvent(Throwable source) {
		super(source);
	}
	public JobExceptionEvent(String code,Throwable source) {
		super(source);
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
