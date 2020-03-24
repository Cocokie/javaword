package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lix.domain.Info;
import com.lix.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-20 09:06
 **/
public class Customize2 {
    public static void main(String[] args) {
        Info user1 = new Info("lixin");
        Info user2 = new Info("lol");
        Info user3 = new Info("kof");
        Info user4 = new Info("like");
        List<Info> list = new ArrayList<Info>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println(list);
        list = list.stream().filter(info -> !info.getXixi().equals("lixin")).collect(Collectors.toList());
        System.out.println(list);
    }
}
