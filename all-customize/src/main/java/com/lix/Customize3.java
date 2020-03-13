package com.lix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customize3 {
    public static void main(String[] args) {
//        String sd = "B123";
//        String[] split = sd.split(",");
//        System.out.println(split[0]);
//        System.out.println(split[1]);
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("c");
        strings.add("c");
        strings.add("sd");
        strings.add("f");
        //Arrays.asList("a", "c", "sd", "f");
        //strings.remove("c");
        System.out.println(strings.toString());
//        int a = strings.indexOf("a");
//        System.out.println(a);
        strings.remove("c");

        System.out.println(strings);

    }
}
