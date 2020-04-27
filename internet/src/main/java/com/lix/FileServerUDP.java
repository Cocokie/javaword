package com.lix;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/**
 * @program: javaworld
 * @description: udp文件传输
 * @author: lixin
 * @create: 2020-03-17 11:20
 **/
public class FileServerUDP {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            DatagramSocket datagramSocket = new DatagramSocket(10086);
            byte[] bytes = new byte[1024 * 60];
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024 * 60], 0, bytes.length);
            System.out.println("服务端已启动");
            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                System.out.println(data.length);
                bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(data));
                String s = String.valueOf((char) (int) (Math.random() * 26 + 97)).toUpperCase();
                System.out.println(s);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(s + String.valueOf(System.currentTimeMillis()+".jpg")));
                byte[] k = new byte[1024];
                int i = -1;
                while ((i = bufferedInputStream.read(k)) != -1) {
                    bufferedOutputStream.write(k, 0, i);
                }
                bufferedOutputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedOutputStream) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedInputStream) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
