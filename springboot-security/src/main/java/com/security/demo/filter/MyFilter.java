package com.security.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "myfilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myfilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("myfilter over");
    }
}
