package com.lix.weixin;

import java.util.Arrays;
import java.util.List;

/**
 * @program: javaworld
 * @description: weixin
 * @author: lixin
 * @create: 2020-01-02 23:46
 **/
public class Customize {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("dsa","dsaewq");
        System.out.println(strings.toString().replace(" ",""));
    }
}
