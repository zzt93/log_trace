package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, "--debug");
	}

	@Bean
	public FilterRegistrationBean addReqeustIdFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MDCAddFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(0);
		return registration;
	}
}
