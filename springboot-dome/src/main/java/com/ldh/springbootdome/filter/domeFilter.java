package com.ldh.springbootdome.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * domeFilter SpringBoot 整合Filter第一种方式 <filter>
 * <filter-name>domeFilter
 * </filter-name>
 * <filter-class>com.ldh.firstboot.filter</filter-class> 
 * </filter>
 * <filter-mapping> 
 * <filter-name>domeFilter</filter-name>
 * <url-pattern>/*</url-pattern> 
 * </filter-mapping>
 */
// @WebFilter(filterName="domeFilter",urlPatterns={*.jsp,*.do})
@WebFilter(filterName = "domeFilter", urlPatterns = "/*")
public class domeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("进入filter设置了编码格式");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        String info = req.getPathInfo();
        String path = req.getServletPath();
        System.out.println("info::" + info);
        System.out.println("path::" + path);
        if (path.equals("/sevlet")) {
            chain.doFilter(request, response);
        }

        System.out.println("离开了filter");

    }

}