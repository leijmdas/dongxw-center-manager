package cn.kunlong.center.config.quartz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.kunlong.center.ApplicationConsts;

@Configuration
public class ScheduleConfig extends ApplicationConsts {

	
	@Bean
	@Lazy(value=false)
	public SchedulerFactoryBean scheduler(@Qualifier("primaryDataSource") DataSource dataSource) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		bean.setApplicationContextSchedulerContextKey("applicationContext");
		bean.setDataSource(dataSource);
		bean.setSchedulerName(QUARTZ_SCHEDULE_NAME);
		bean.setStartupDelay(10);
		bean.setAutoStartup(true);
		
		
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource(QUARTZ_CONFIG_LOCATION));
		return bean;
	}
}
