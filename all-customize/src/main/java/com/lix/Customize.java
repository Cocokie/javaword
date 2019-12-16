package com.lix;

import com.lix.domain.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customize {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", 200),
                new Dish("xxx", 122),
                new Dish("aaa", 321),
                new Dish("bbb", 861),
                new Dish("ccc", 1543)
        );
       // getDishNamesByCollections(menu);//查找能量低于500的食物的名字，并且排序,通过传统方式
        //getDishNamesByStream(menu);//查找能量低于500的食物的名字，并且排序，通过Stream
    }

    public static void getDishNamesByStream(List<Dish> menu) {
        Stream<Dish> stream = menu.stream();
        System.out.println(stream);

        List<String> collect = menu.stream().filter(d -> d.getEnergy() < 400)
                .sorted((d1, d2) -> d1.getEnergy().compareTo(d2.getEnergy()))
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
        collect.stream().forEach(x -> System.out.println(x));
    }

    public static void getDishNamesByCollections(List<Dish> menu) {
        menu.sort((d1, d2) -> d1.getEnergy().compareTo(d2.getEnergy()));
        for (Dish dish : menu) {
            System.out.println(dish);
        }
        List<String> emptyList = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getEnergy() < 400) {
                emptyList.add(dish.getName());
            }
        }
        for (String s : emptyList) {
            System.out.println(s);
        }
    }

    public  void getDishNamesByStream() {
    }
}
