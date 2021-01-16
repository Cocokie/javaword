package com.lix.mapper;

import com.lix.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    List<User> queryAll();
    User queryById(@Param("id") int id, @Param("account")int i);
}
