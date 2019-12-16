package com.lix.customize;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationJedis {
    public static void main(String[] args) {
        //operateString();
        //operateHashMap();


    }

    private static void operateHashMap() {
        Jedis jedis = JedisUtils.getJedis();
        HashMap s = new HashMap();
        Map<String, String> users = jedis.hgetAll("users");

        System.out.println(users.toString());
    }

    private static void operateString() {
        Jedis jedis = JedisUtils.getJedis();

        jedis.setnx("uname","lixin");
        String uname = jedis.get("username");
        System.out.println(uname);
    }
}
