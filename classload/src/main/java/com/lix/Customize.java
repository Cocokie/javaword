package com.lix;

import lombok.Data;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-11 10:32
 **/
@Data
public class Customize {
    static {
        System.out.println("Customize 被加载了");
    }

    public static void main(String[] args) {

    }

    public void getInfo() {
        System.out.println("Customize.getInfo");
    }
}
