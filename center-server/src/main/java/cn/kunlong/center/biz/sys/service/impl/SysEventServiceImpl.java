package cn.kunlong.center.biz.sys.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.sys.domain.SysDomain;
import cn.kunlong.center.biz.sys.service.SysEventService;
import cn.kunlong.center.core.util.StringUtil;

@Service
public class SysEventServiceImpl implements SysEventService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysEventServiceImpl.class);
	
	@Autowired
	private MailSender mailSender;
	/**
	 * 级别5以上，立即发送邮件
	 * 简单处理
	 */
	@Override
	public void alert(SysDomain domain, Integer level,String subject, String info) {
		logger.info("业务告警[{}][{}][{}]:{}",new Object[]{domain.getDomainCode(),domain.getDomainName(),level,info});
		if(level>5){
			try {
				String _subject = "业务告警["+domain.getDomainCode()+"]";
				mailSender.send(_subject+subject, "---------"+domain.getDomainName()+"业务告警["+level+"]----<br/>"+info);
			} catch (Exception e) {
				logger.warn("发送告警邮件异常");
			} 
		}
	}
	
	@Service
	public static class MailSender{
		
		@Autowired
		private JavaMailSender javaMailSender;

		@Value("${mail.sender}")
		private String sender;

		@Value("${mail.sendernick}")
		private String sendernick;

		@Value("${mail.recipients}")
		private String recipients;

		public void send(String subject,String content) throws MessagingException, UnsupportedEncodingException{
			if ( this.getRecipientList() == null || this.getRecipientList().length == 0) {
				return;
			}
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setTo(this.getRecipientList());
			
			helper.setFrom(new InternetAddress(String.format("%s <%s>", MimeUtility.encodeText(sendernick), sender)));
			helper.setSubject(subject);
			helper.setText(content);
			javaMailSender.send(mimeMessage);
		}

		public JavaMailSender getJavaMailSender() {
			return javaMailSender;
		}

		public void setJavaMailSender(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getSendernick() {
			return sendernick;
		}

		public void setSendernick(String sendernick) {
			this.sendernick = sendernick;
		}

		public String getRecipients() {
			return recipients;
		}

		public void setRecipients(String recipients) {
			this.recipients = recipients;
		}

		public String[] getRecipientList() {
			return StringUtil.trimToEmpty(this.recipients).split(";");
			
		}
		
		
	}
}
