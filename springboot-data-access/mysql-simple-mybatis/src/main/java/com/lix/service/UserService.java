package com.lix.service;

import com.lix.domain.User;
import com.lix.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void transfer(String username, Double amount) {
        List<User> userList = userMapper.queryAll();
        for (User user : userList) {
            System.out.println(user);
        }

    }
}
