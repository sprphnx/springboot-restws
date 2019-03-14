package com.sprphnx.sb.restws.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class AppConfig {

	@Bean
	public LocaleResolver localeResolver() {
		//This can be used when @RequestHeader is specifically given in the controller
		//for a service
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		//This is used to read the Accept-Language property automatically from the header.
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	//Instead of configuring the below bean, the base name can be mentioned 
	//in application.propertier
/*	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/

}
