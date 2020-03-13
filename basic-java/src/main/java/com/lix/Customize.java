package com.lix;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-06 18:36
 **/
class C {
    C() {
        System.out.println("c");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.println("A");
    }

    A(String s) {
        System.out.println(s);
    }
}

public class Customize extends A {
    Customize(){
        super("B");
        System.out.println("B");
    }
    public static void main(String[] args) {
        new Customize();
    }
}
