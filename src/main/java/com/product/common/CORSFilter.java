package com.product.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

  /**
   *
   * Purpose: This method is to implement cross origin resource sharing
   * 
   * @param Http request
   * @param Http response
   * @param filterChain
   * 
   * @see : Data
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");
    if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
      LOGGER.debug("Sending Header....");
      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
      // response.addHeader("Access-Control-Allow-Headers", "Authorization");
      response.addHeader("Access-Control-Allow-Headers", "Content-Type");
      response.addHeader("Access-Control-Max-Age", "1");
    }
    filterChain.doFilter(request, response);
  }

}
