package com.lix;

import com.lix.domain.Apple;
import com.lix.interFace.AppleHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Customize {
    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(
                new Apple("red",1l),
                new Apple("black",12l),
                new Apple("white",36l));
        findApple(list, apple -> apple.getColor().equals("red"));
    }
    public static void findApple(List<Apple> list ,AppleHandler appleHandler){
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : list) {
            if(appleHandler.filterApple(apple)){
                apples.add(apple);
            }
        }
        System.out.println(apples);
    }
}
