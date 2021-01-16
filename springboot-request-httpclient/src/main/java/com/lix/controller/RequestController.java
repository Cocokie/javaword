package com.lix.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RequestController {


    @PostMapping("getNoArg")
    public String getNoArg(@RequestParam List<String> userIds) {

        System.out.println(JSON.toJSONString(userIds));

        return JSON.toJSONString(userIds);
    }

    @GetMapping("getArg")
    public String getArg(String name, String age) {
        return "success";
    }

    @PostMapping("postForm")
    public String postForm(@RequestParam List<String> userIds) {
        System.out.println(userIds);
        return "success";
    }

    @PostMapping("postJson")
    public String postJson() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = request.getParameter("name");
        System.out.println(name);
        System.out.println(request.getMethod());

        return "success";
    }
}
