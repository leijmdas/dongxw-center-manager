package cn.integriti.center.config.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailSenderConfig {

	@Bean
	@ConfigurationProperties(prefix = "mail")
	public JavaMailSender mailSender() {
		org.springframework.mail.javamail.JavaMailSenderImpl sender = new org.springframework.mail.javamail.JavaMailSenderImpl();
		return sender;
	}
}
