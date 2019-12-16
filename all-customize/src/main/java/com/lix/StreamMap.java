package com.lix;

import com.lix.domain.Dish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,6,2,4,6,1,9);
        //增大两倍
        List<Integer> collect = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(collect);
        //
        List<Dish> menu = Arrays.asList(
                new Dish("pork", 200),
                new Dish("xxx", 122),
                new Dish("aaa", 321),
                new Dish("bbb", 861),
                new Dish("ccc", 1543)
        );
        List<String> collect1 = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(collect1);
        //menu.stream().collect(Collectors.toMap(Dish::getEnergy,Dish::new));

    }
}
