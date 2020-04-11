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
            int line = -1;
            char []buf = new char[100];
            StringBuffer stringBuffer = new StringBuffer();
            System.out.println("开始读取");
          CharArrayWriter charArrayWriter  = new CharArrayWriter();
            while ((line = bufferedReader.read(buf)) != -1) {
                String s = new String(buf, 0, buf.length);
                System.out.println(s);
                charArrayWriter.write(buf,0,buf.length);
                charArrayWriter.flush();
              //  stringBuffer.append(s);
            }
            System.out.println(charArrayWriter.toString());
            System.out.println("====================");
           // System.out.println(stringBuffer.toString());
            bufferedReader.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
