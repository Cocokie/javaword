package com.lix.controller;

import com.lix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Value("李昕")
    String lix;

    public void getUser() {
        System.out.println("UserController.getUser");
        System.out.println(lix);
        userService.getUser();
    }
}
