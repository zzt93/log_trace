package com.github.zzt93.metric;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

/**
 * @author zzt
 */
@Component
public class LatencyMonitorFilter implements Filter {

  private static final String prefix = "api.";
  @Autowired
  private CounterService counterService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    try {
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      counterService.increment(prefix + ((HttpServletRequest) servletRequest).getRequestURI());
    }
  }

  @Override
  public void destroy() {
  }
}
