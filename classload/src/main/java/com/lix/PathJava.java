package com.lix;

import java.io.*;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

/**
 * @program: java world
 * @description: 路径测试
 * @author: lixin
 * @create: 2020-03-11 11:08
 **/
public class PathJava {
    public static void main(String[] args) throws Exception {
        //路径都是相对当前工程运行目录new File()
        // pathFile();


        //直接Class.getResource()要加"/"才能定位到 类路径下的文件资源，否则就是定位到当前包
        //classLoad.getResource()直接定位到类路径下
        //如果为jar包，就是定位到当前jar的路径位置
        //propertiesPath();

        //url uri 的一些方法
        //urlOpenStream();

        Class<Customize> aClass = (Class<Customize>) PathJava.class.getClassLoader().loadClass("com.lix.Customize");
        Customize customize = aClass.newInstance();
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
            System.out.println(annotation);
        }
        customize.getInfo();
    }

    private static void urlOpenStream() throws IOException {
        //URI u = new URI("https://www.hnwanz.com/api/device/device/detail?deviceId=3f95fe0c2d4f472f8c321552a16da880");
        URL u = new URL("https://www.hnwanz.com/api/device/device/detail?deviceId=3f95fe0c2d4f472f8c321552a16da880");
        System.out.println(u.getProtocol());
        System.out.println(u.getHost());
        System.out.println(u.getPort());
        System.out.println(u.getPath());
        System.out.println(u.getQuery());
        System.out.println(u.getAuthority());
        System.out.println(u.getRef());
        InputStream inputStream = u.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        String k = null;
        while ((k = bufferedReader.readLine()) != null) {
            System.out.println(k);
        }
    }

    private static void propertiesPath() throws IOException {
        URL resource = PathJava.class.getResource("");
        URL resourceClassLoader = PathJava.class.getClassLoader().getResource("xx.properties");
        InputStream inputStream = resourceClassLoader.openStream();
//        Properties p = new Properties();
//        p.load(inputStream);
//        System.out.println(p.getProperty("name"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        String k = null;
        while ((k = bufferedReader.readLine()) != null) {
            System.out.println(k);
        }
        System.out.println(resource);
        System.out.println(resourceClassLoader);
    }

    private static void pathFile() throws IOException {
        String userdir = System.getProperty("user.dir");
        // System.out.println(property);
        System.out.println(userdir);
        File f = new File("classload/coco.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());
        System.out.println(f.getCanonicalFile());
        System.out.println(f.getCanonicalPath());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("classload/coco.txt"));
        bufferedWriter.write("诺克萨斯");
        bufferedWriter.newLine();
        bufferedWriter.write("断头台");
        bufferedWriter.newLine();
        bufferedWriter.write("咿呀");
        bufferedWriter.close();
    }
}
