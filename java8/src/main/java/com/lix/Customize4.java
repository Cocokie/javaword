package com.lix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Customize4 {
    public static void main(String[] args) {
        List<String> activityIds = Arrays.asList("x", "3ewq", "lol");
        System.out.println(activityIds.toString());
        //collect
        List<String> collect = Arrays.asList("a", "b");
        System.out.println(collect);
        Map<String, String> collect1 = activityIds.stream().
                collect(Collectors.toMap(key -> key, key -> {
                    if(collect.size()-1<activityIds.indexOf(key)){
                        return "null";
                    }
                    return collect.get(activityIds.indexOf(key));
                }));
        System.out.println(collect1);
       // activityIds.stream()
        Map m = new HashMap();
        m.put("dsa", null);
        System.out.println(m);
        System.out.println(m.get(null));
    }
}
