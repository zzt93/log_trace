package com.github.zzt93.metric;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

/**
 * @author zzt
 */
@Component
public class TraceLoggerRepo implements TraceRepository {

  private Logger logger = LoggerFactory.getLogger(TraceLoggerRepo.class);


  @Override
  public List<Trace> findAll() {
    return Collections.emptyList();
  }

  @Override
  public void add(Map<String, Object> traceInfo) {
    Trace trace = new Trace(new Date(), traceInfo);
//    counterService.increment("counter.trace");
//    gaugeService.submit("", );
    logger.warn("{}", traceInfo);
  }
}
