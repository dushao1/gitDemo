package com.avicsafety.webapp.conf;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.GenericFilterBean;

//@Component
public class MyCorsFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getMethod().equals(RequestMethod.OPTIONS.name()))
        {
            response.setStatus(HttpStatus.OK.value());
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "PUT,POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "application/x-www-form-urlencoded,x-requested-with,Authorization");
            response.setHeader("Access-Control-Allow-Credentials","true");
            System.out.println("MyCorsFilter");
            
            //essage":"No suitable HttpMessageConverter found to read request body into object of type class com.avicsafety.webapp.entity.User from request with content type of application/x-www-form-urlencoded;charset=UTF-8!"}
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
