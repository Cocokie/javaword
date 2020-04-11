package com.lix;

import org.elasticsearch.common.util.ByteArray;

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
            //Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + "   正在运行中。。。");
            InputStream inputStream = server.getInputStream();
            OutputStream outputStream = server.getOutputStream();
            //System.out.println(inputStream);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            byte[] b = new byte[5 * 1024];
            int k = -1;
            while ((k = bufferedInputStream.read(b)) != -1) {
                System.out.println(new String(b));
            }
            printWriter.println("abc");
            printWriter.flush();
            System.out.println("================");
            outputStream.close();
            bufferedInputStream.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
