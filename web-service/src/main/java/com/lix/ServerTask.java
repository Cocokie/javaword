package com.lix;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class ServerTask implements Runnable {
    Socket server;

    public ServerTask(Socket server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            InputStream inputStream = server.getInputStream();
            //System.out.println(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(server.getOutputStream());
            bufferedOutputStream.write("over".getBytes());
            bufferedOutputStream.flush();

            server.shutdownOutput();
            bufferedReader.close();
            bufferedOutputStream.close();
            server.close();
            System.out.println("结束了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
