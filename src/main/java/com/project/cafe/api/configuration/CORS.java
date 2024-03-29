package com.project.cafe.api.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter {

  @Value("${rest.request.header.key}")
  private String REQUEST_HEADER_KEY;

  @Value("${rest.request.header.version}")
  private String REQUEST_HEADER_VERSION;

  @Override
  public void doFilter(
    ServletRequest req,
    ServletResponse res,
    FilterChain chain
  ) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    // Allow host?
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader(
      "Access-Control-Allow-Methods",
      "DELETE, GET, OPTIONS, PATCH, POST, PUT"
    );
    response.setHeader("Access-Control-Max-Age", "7200");
    response.setHeader(
      "Access-Control-Allow-Headers",
      "X-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN"
    );

    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
    } else {
      chain.doFilter(req, res);
    }
  }
}
