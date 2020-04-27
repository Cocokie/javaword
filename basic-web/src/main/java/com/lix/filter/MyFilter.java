package com.lix.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: basic-web
 * @description:
 * @author: lixin
 * @create: 2020-03-20 13:31
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filterConfig: " + filterConfig.getInitParameter("name"));
        ServletContext servletContext = filterConfig.getServletContext();

        //System.out.println("servletContext: " + servletContext.getInitParameter("name"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter1 " + servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
