package com.lix;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTask implements Runnable {
    Socket server;

    public ServerTask(Socket server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "   正在运行中。。。");
            InputStream inputStream = server.getInputStream();
            //System.out.println(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println("第一行:" + s);
            bufferedReader.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
