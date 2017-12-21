package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zzt
 */
@Configuration
@ConditionalOnClass(MDCFetchFilter.class)
public class LogFilterConfig {
  @Bean
  public FilterRegistrationBean fetchIdFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new MDCFetchFilter());
    registration.addUrlPatterns("*");
    registration.setName("MDCFetchFilter");
    registration.setOrder(-2);
    return registration;
  }
}
