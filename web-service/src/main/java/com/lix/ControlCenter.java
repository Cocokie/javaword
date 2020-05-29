package com.lix;

import com.lix.threadpool.SimpleThreadPool;
import com.lix.xmlcontainer.ServletClass;
import com.lix.xmlcontainer.WebApp;
import com.lix.xmlparams.WebXmlOperate;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @program: javaworld
 * @description: 控制中心
 * @author: lixin
 * @create: 2020-03-18 16:51
 **/
public class ControlCenter {


    public static void main(String[] args) throws Exception {
        System.out.println("----server----");
        ServerSocket serverSocket = new ServerSocket(8889);

        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        while (true) {
            Socket server = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            simpleThreadPool.submitTask(new ServerTask(server));
          // new Thread(new ServerTask(server)).start();
        }
//        WebApp webApp = WebXmlOperate.parseXml("myWeb.xml");
//        String clazz = webApp.getClazz("/lo");
//        System.out.println(clazz);
    }
}
