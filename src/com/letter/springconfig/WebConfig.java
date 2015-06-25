package com.letter.springconfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Controller for i18n
 *
 * @author Rune Krauss
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.letter")
public class WebConfig {
	
	/**
	 * Method to resolve the view
	 * 
	 * @return InternalResourceViewResolver An object for resolving
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * Method to initialize i18n
	 * 
	 * @return MessageSource An object for i18n
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}