package cn.kunlong.center;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"cn.kunlong"})
@ImportResource(locations= {"classpath:/dubbo-provider.xml"})
@org.apache.dubbo.config.spring.context.annotation.EnableDubbo
@EnableDubboConfig
public class CenterApp {

	public static void main(String[] args) {
		SpringApplication.run(CenterApp.class, args);
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setWebApplicationType(WebApplicationType.NONE);
//		app.run(args);
	}
}