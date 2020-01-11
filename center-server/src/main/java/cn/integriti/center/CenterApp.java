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
public class CenterApp {

	public static void main(String[] args) {
		SpringApplication.run(CenterApp.class, args);
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setWebApplicationType(WebApplicationType.NONE);
//		app.run(args);
	}
}