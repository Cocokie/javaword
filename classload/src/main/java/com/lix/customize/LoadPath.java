package com.lix.customize;

import java.io.File;

public class LoadPath {
    public static void main(String[] args) {
        ClassLoader classLoader = LoadPath.class.getClassLoader();
        System.out.println("当前程序所在目录：" + System.getProperty("user.dir")); // 当前程序所在目录
        System.out.println("file:" + new File("").getAbsolutePath());

        System.out.println(LoadPath.class.getResource("/"));
        System.out.println(LoadPath.class.getResource(""));
        System.out.println(classLoader.getResource("/"));
        System.out.println(classLoader.getResource("xx.properties"));
        System.out.println(classLoader.getResource(""));


    }
}
