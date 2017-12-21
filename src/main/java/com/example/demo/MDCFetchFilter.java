package com.example.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.MDC;

/**
 * @author zzt
 */
public class MDCFetchFilter implements Filter {


  private static final String REQUEST_ID = "requestId";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    MDC.put(REQUEST_ID, ((HttpServletRequest) servletRequest).getHeader(REQUEST_ID));
    try {
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      MDC.remove(REQUEST_ID);
    }
  }

  @Override
  public void destroy() {
  }
}
