package com.github.zzt93.metric;

import io.micrometer.spring.web.servlet.DefaultWebMvcTagsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzt
 */
@Configuration
public class TagProvider {

  @Bean
  public DefaultWebMvcTagsProvider servletTagsProvider() {
    return new RemoveIdWebMvcTagsProvider();
  }

}
