package com.lix.lambdas;

import com.lix.domain.Apple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LambdaExpression {
    public static void main(String[] args) {
        Supplier<String> supplier =String::new;
        String s =supplier.get();
        System.out.println(s);

        BiFunction<String,Long, Apple> appleBiFunction = Apple::new;
        Apple apple = appleBiFunction.apply("red",122l);
        System.out.println(apple);
    }
}
