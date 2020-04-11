package com.lix;

import java.io.*;

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

    Customize() {
        this("dsa");
        System.out.println("B");
    }

    Customize(String i) {
        super("B");
        System.out.println("sd");
    }

    public static void main(String[] args) throws IOException {
        new Customize();
        System.out.printf("%s", "sda");
        System.out.println(FileDescriptor.out);

        PrintStream out = System.out;
    }
}
