package com.lix.springmvc.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        System.out.println(name);
        httpServletResponse.getWriter().print("hahahha");
    }
}
