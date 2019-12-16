package com.lix;

import com.lix.domain.Dish;

import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {

        Dish d = new Dish("lx",1);
        Dish d1 = new Dish("xie",5);
        Dish d2 = new Dish("qi",2);
        TreeSet treeSet = new TreeSet();
        treeSet.add(d);
        treeSet.add(d1);
        treeSet.add(d2);
        System.out.println(treeSet);
    }
}
