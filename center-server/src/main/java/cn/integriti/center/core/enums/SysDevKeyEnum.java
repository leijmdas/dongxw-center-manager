package cn.integriti.center.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum SysDevKeyEnum {
	HOSPITAL_NAME("医院名称", "hospital.name"), 
	SYSTEM_SERIALNO("序列号", "system.serialNo"), 
	
	REPORT_ANONYMOUS_STATE("匿名上报开关状态", "report.anonymous.state"),
	
	REPORT_ANONYMOUS_EVENT_TYPES("匿名上报类型","report.anonymous.eventTypes"),
	
	REPORT_PROCESS_ID("应用流程ID","report.current.processId"),
	
	API_HIS_URL("病案接口地址","api.his.url"),
	API_HIS_PARAM_NAME("病案接口参数名","api.his.paramName"),
	
	NOTICE_EMAIL_STATE("邮件提醒开关状态","notice.email.state"),
	NOTICE_EMAIL_SMTP_HOST("SMTP邮件发送服务器","notice.email.smtp.host"),
	NOTICE_EMAIL_SMTP_PORT("SMTP邮件发送服务器端口","notice.email.smtp.port"),
	NOTICE_EMAIL_SENDER_USERNAME("帐号","notice.email.sender.username"),
	NOTICE_EMAIL_SENDER_PASSWORD("密码","notice.email.sender.password");
	
	
	private String name;

	private String value;

	private SysDevKeyEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
	
	public static Map<String,String> toMap(){
		SysDevKeyEnum[] enums = SysDevKeyEnum.values();
		Map<String,String> statusMap = new HashMap<String,String>();
		for(SysDevKeyEnum en:enums){
			statusMap.put(en.getValue(), en.getName());
		}
		return statusMap;
	}

}
