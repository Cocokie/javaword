package com.lix.customize;

public class ClassPath {
    public static void main(String[] args) {

        System.out.println(int.class.getClassLoader());
        String[] split = System.getProperty("sun.boot.class.path").split(";");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println("================================");
        String[] split2 = System.getProperty("java.ext.dirs").split(";");
        for (String s : split2) {
            System.out.println(s);
        }
        System.out.println("================================");
        String[] split3 = System.getProperty("java.class.path").split(";");
        for (String s : split3) {
            System.out.println(s);
        }
    }
}
