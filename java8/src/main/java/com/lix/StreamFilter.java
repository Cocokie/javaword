package com.lix;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,6,2,4,6,1,9);
        //过滤取偶数，排序
        List<Integer> collect = list.stream().filter(i -> i % 2 == 0)
                .sorted(Comparator.comparingInt(i -> i))
                .collect(Collectors.toList());
        System.out.println(collect);
        //去重
        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);
        //取值跳过几个 取后面
        List<Integer> collect2 = list.stream().skip(3).collect(Collectors.toList());
        System.out.println(collect2);

        //取值前面
        List<Integer> collect3 = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect3);
    }
}
