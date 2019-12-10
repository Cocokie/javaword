package com.lix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class Customeize {
    public static void main(String[] args) {

        String sd = "xixi";
        byte[] bytes = sd.getBytes();
        System.out.println(bytes.length);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        System.out.println(bytes);
    }
}
