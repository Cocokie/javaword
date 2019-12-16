package com.lix.service;

import com.lix.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    HashOperations<String, String, Object> hashOperations;

    public User selectById(String id) {
       return null;
    }
}
