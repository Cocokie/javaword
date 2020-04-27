package com.lix.springmvc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerAnnotation {
    @GetMapping("/get")
    public String get() {
        System.out.println("wozhe1");
        return "嘀嘀嘀";
    }

}
