package com.pro.ClienteApp.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

//@Configuration
public class InternacionalizacaoConfig {
/**
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("ISO-8859-1"); // Para reconhecer os caracteres especiais usados no brasil;
		messageSource.setDefaultLocale(Locale.getDefault());
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean; 
	} */
}
