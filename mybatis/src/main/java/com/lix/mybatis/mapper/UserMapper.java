package com.lix.mybatis.mapper;

import com.lix.mybatis.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User> getUsers();
    User getUserById(String id);
}
