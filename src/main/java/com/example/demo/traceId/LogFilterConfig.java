package com.example.demo.traceId;

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

  @Bean
  public FilterRegistrationBean addRequestIdFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new MDCAddFilter());
    registration.addUrlPatterns("/*");
    registration.setOrder(-3);
    return registration;
  }
}
