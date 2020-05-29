package com.lix.collection;

import com.lix.domain.User;

import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        User u = new User("lixin", 18);
        User u1 = new User("lixin2", 19);
        User u2 = new User("lixin3", 20);
        TreeSet<User> users = new TreeSet();
        users.add(u);
        users.add(u1);
        users.add(u2);
        users.forEach(user -> {
            System.out.println(user.toString());
        });


    }
}
