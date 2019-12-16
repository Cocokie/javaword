package com.lix.customize;

import redis.clients.jedis.Jedis;

import java.util.Comparator;
import java.util.HashMap;


//Jedis小试试
public class Customize {
    public static void main(String[] args) {
        User u = new User("lixin",18);
        System.out.println(u.hashCode());
        User b = new User("abc",0);
        HashMap hashMap = new HashMap();
        hashMap.put(u,"uuu");
        hashMap.put(b,"bbb");
        System.out.println(hashMap);
        System.out.println(hashMap.get(u));
        Thread th = new Thread(() -> System.out.println("dsa"),"name2");
        th.start();

    }
}
