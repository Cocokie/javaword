package com.lix.tcp;

/**
 * @program: javaworld
 * @description: tcp服务器
 * @author: lixin
 * @create: 2020-02-27 17:44
 **/

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作:输入输出流操作
 * 4.释放资源
 */
public class ServerLx {
    public static void main(String[] args) throws Exception {
        System.out.println("----server----");
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true) {
            Socket server = serverSocket.accept();

            System.out.println("一个客户端建立了连接");
            TimeUnit.SECONDS.sleep(20);
            DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
            System.out.println("处理中...");
            String s = dataInputStream.readUTF();
            System.out.println(s);
            dataInputStream.close();
            server.close();
        }
    }
}
