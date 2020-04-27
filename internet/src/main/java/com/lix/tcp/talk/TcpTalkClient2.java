package com.lix.tcp.talk;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpTalkClient2 {
    //1.使用DatagramSocket 指定端口，创建发送端
    //2.准备数据，转成byte []形式
    //3.把数据放到DatagramPacket包裹中，需要指明目的地
    //4.send()发送
    public static void main(String[] args) throws IOException {
        System.out.println("----client----");
        boolean isRunning =true;
        Socket client = new Socket("localhost", 8889);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        BufferedReader readerKey = new BufferedReader(new InputStreamReader(System.in));

        while (isRunning) {
            String data = readerKey.readLine();
            dataOutputStreamRead(outputStream, data);
            dataInputStreamRead(inputStream);
        }
        outputStream.close();
        inputStream.close();
    }

    private static void dataInputStreamRead(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
        String s = dataInputStream.readUTF();
        System.out.println(s);
    }

    private static void dataOutputStreamRead(OutputStream outputStream, String data) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
    }

}
