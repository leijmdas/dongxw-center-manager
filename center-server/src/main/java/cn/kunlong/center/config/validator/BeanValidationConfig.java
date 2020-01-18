package cn.kunlong.center.config.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import cn.kunlong.center.biz.support.validation.BeanValidator;

@Configuration
public class BeanValidationConfig {

	@Bean
	public LocalValidatorFactoryBean validatorFactory(){
		LocalValidatorFactoryBean factory = new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
		BeanValidator.setValidatorFactory(factory);
		return factory;
	}
}
