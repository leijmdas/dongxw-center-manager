package cn.integriti.center;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"cn.integriti"})
@EnableDubbo
@ImportResource(locations= {"classpath:/dubbo-provider.xml"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}