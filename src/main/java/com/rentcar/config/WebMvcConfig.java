package com.rentcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean 
	public ServletContextTemplateResolver templateResolver() {
	    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
	    resolver.setPrefix("resource/template/");
	    resolver.setSuffix(".html");
	    resolver.setTemplateMode("HTML5");
	    resolver.setOrder(1);
	    return resolver;
	}
}
