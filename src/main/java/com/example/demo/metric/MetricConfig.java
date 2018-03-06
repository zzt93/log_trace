package com.example.demo.metric;

import io.micrometer.core.instrument.Clock;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzt
 */
@Configuration
public class MetricConfig {

  @Bean
  public PrometheusMeterRegistry prometheusMeterRegistry(
      PrometheusConfig prometheusConfig, CollectorRegistry collectorRegistry,
      Clock clock) {
    return new PrometheusMeterRegistry(prometheusConfig, collectorRegistry, clock);
  }
}
