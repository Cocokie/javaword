package com.lix.service;

import com.lix.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "sss")
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public void getUser() {
        System.out.println("UserService.getUser");
        userMapper.getUser();
        userMapper.addAccount("lixin", "200");
        System.out.println(1 / 0);
        userMapper.reduceAccount("lover", "200");
    }
}
