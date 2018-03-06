package com.example.demo.metric;

import com.sun.deploy.trace.Trace;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Component;

/**
 * @author zzt
 */
@Component
public class TraceLoggerRepo implements HttpTraceRepository {

  private Logger logger = LoggerFactory.getLogger(TraceLoggerRepo.class);

  @Override
  public List<HttpTrace> findAll() {
    return Collections.emptyList();
  }

  @Override
  public void add(HttpTrace trace) {

  }


}
