package com.lix;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Customize2 {
    public static void main(String[] args) {

        BiFunction<String,Integer,Character> f2 = String::charAt;
        Character c = f2.apply("hello",2);
        System.out.println(c);

        String sd = new String("hello");
        Function<Integer,Character> f = index -> sd.charAt(index);
        System.out.println(f.apply(2));

    }
}
