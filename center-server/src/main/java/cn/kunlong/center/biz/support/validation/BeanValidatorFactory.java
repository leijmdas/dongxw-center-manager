package cn.kunlong.center.biz.support.validation;

import org.springframework.context.MessageSource;

@Deprecated
public class BeanValidatorFactory extends org.springframework.validation.beanvalidation.LocalValidatorFactoryBean {
    private MessageSource messageSource;

    @Override
    public void setValidationMessageSource(MessageSource messageSource) {
        super.setValidationMessageSource(messageSource);
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

}
