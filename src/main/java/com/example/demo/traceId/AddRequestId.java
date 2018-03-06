package com.example.demo.traceId;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author zzt
 */
public class AddRequestId extends HttpServletRequestWrapper {
  private static final String REQUEST_ID = "requestId";

  public AddRequestId(HttpServletRequest request) {
    super(request);
  }

  public String getHeader(String name) {
    if (name.equals(REQUEST_ID)) {
      return "1asd";
    }
    String header = super.getHeader(name);
    return (header != null) ? header : super.getParameter(name); // Note: you can't use getParameterValues() here.
  }

  public Enumeration getHeaderNames() {
    List<String> names = Collections.list(super.getHeaderNames());
    names.addAll(Collections.list(super.getParameterNames()));
    return Collections.enumeration(names);
  }
}
