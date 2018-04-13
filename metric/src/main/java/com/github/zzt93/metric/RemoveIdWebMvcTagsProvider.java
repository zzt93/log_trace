package com.github.zzt93.metric;

import io.micrometer.core.instrument.Tag;
import io.micrometer.spring.web.servlet.DefaultWebMvcTagsProvider;
import io.micrometer.spring.web.servlet.WebMvcTags;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zzt
 */
public class RemoveIdWebMvcTagsProvider extends DefaultWebMvcTagsProvider {

  private Pattern idMatcher = Pattern.compile("/[0-9]+");

  @Override
  public Iterable<Tag> httpRequestTags(HttpServletRequest request, HttpServletResponse response,
      Object handler, Throwable ex) {
    Tag tag = WebMvcTags.uri(request, response);
    String uri = tag.getValue();
    Matcher matcher = idMatcher.matcher(uri);
    if (matcher.find()) {
      String value = matcher.replaceAll("/{id}");
      return Arrays.asList(WebMvcTags.method(request), Tag.of(tag.getKey(), value),
          WebMvcTags.exception(ex), WebMvcTags.status(response));
    }
    return super.httpRequestTags(request, response, handler, ex);
  }
}
