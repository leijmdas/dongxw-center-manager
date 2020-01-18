package com.tf.erp.test.module;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tf.erp.test.BaseTest;

import cn.kunlong.center.biz.sys.service.impl.SysEventServiceImpl.MailSender;

public class MailSenderTest extends BaseTest{

	@Autowired
	private MailSender mailSender;

	@Test
	public void test4Send0() throws UnsupportedEncodingException, MessagingException {
		
		mailSender.send("测试", "测试");
	}
}
