package com.lix.customize;

public class StaticInit {
    static final int k =6;
    static {
        //System.out.println(7772);

    }
    public static void main(String[] args) throws ClassNotFoundException {
        //Class<ClassPath> classPathClass = ClassPath.class;
        Class<?> classPath = StaticInit.class.getClassLoader().loadClass("com.lix.customize.ClassPath");
    }
}
