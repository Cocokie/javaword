package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import sun.misc.Launcher;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Properties;

/**
 * @program: javaworld
 * @description: 加载的类或文件
 * @author: lixin
 * @create: 2020-03-16 08:57
 **/
public class LoadJava {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.lix.Customize");

        //Launcher

        //basicLoadPath();
    }

    /**
     * 类加载的基本路径，双亲委托
     */
    private static void basicLoadPath() {

        String bootClassLoad = System.getProperty("sun.boot.class.path");
        for (String s : bootClassLoad.split(";")) {
            System.out.println(s);
        }
        System.out.println("====================================");
        String extClassLoad = System.getProperty("java.ext.dirs");
        for (String s : extClassLoad.split(";")) {
            System.out.println(s);
        }
        System.out.println("====================================");
        String appClassLoad = System.getProperty("java.class.path");
        for (String s : appClassLoad.split(";")) {
            System.out.println(s);
        }
    }
}
