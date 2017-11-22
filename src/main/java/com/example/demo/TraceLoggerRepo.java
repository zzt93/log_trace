package com.example.demo;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

/**
 * @author zzt
 */
@Component
public class TraceLoggerRepo implements TraceRepository {


  @Override
  public List<Trace> findAll() {
    return Collections.emptyList();
  }

  @Override
  public void add(Map<String, Object> traceInfo) {
    Trace trace = new Trace(new Date(), traceInfo);
    // write to file or db
    System.out.println(traceInfo);
  }
}
