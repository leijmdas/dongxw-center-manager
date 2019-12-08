package com.tf.erp.test;

import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"cn.integriti.center"})
public class Application {
	
	public static void println(Object obj){
		ObjectMapper m = new ObjectMapper();
		m.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		try {
			String tmp = m.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println("---------------------------\n"+tmp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
