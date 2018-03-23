package com.strpad.com.strpad.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(1)
public class StrPadFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(StrPadFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Starting filter");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        /*System.out.println("request.getRequestURI(): " + request.getRequestURI());
        System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
        System.out.println("request.getRemoteHost(): " + request.getRemoteHost());
        */
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method");
    }

    @Bean
    public FilterRegistrationBean myFilterBean() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new StrPadFilter());
        filterRegBean.addUrlPatterns("/*");
        filterRegBean.setEnabled(Boolean.TRUE);
        filterRegBean.setName("My Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }
}
