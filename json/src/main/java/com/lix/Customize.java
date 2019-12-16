package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lix.domain.Address;
import com.lix.domain.Info;
import com.lix.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Customize {
    public static void main(String[] args) {
        Info info = new Info("infoDemo");
        List<Address> list = new ArrayList<Address>();
        list.add(new Address("changsha"));
        list.add(new Address("leiyang"));
        User u = new User("LIXIN", list, info,null);
        List<User> users = new ArrayList<User>();
        users.add(u);
        JSONArray o = (JSONArray) JSON.toJSON(users);
        System.out.println(o);
//        List<User> users1 = JSON.parseArray(o.toString(), User.class);
        List<User> parse = (List<User>) JSON.parse(o.toString());
        List<User> o1 = JSON.parseObject(o.toString(), new TypeReference<List<User>>(){});
//        JSONObject o = (JSONObject) JSON.to JSON(u);
//        System.out.println(o.toString());
//        User user = JSON.parseObject(o.toString(), User.class);
        System.out.println("sss");
       // JSON.
    }
}
