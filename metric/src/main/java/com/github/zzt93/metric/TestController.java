package com.github.zzt93.metric;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzt
 */
@RestController
public class TestController {

  @GetMapping("/test")
  public String test() {
    return "test " + new Random().nextInt();
  }

  @GetMapping("/timed")
  public String waited() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    return "waited " + new Random().nextInt();
  }
}
