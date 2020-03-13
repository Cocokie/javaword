package com.lix.udp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    //1.使用DatagramSocket 指定端口，创建发送端
    //2.准备数据，转成byte []形式
    //3.把数据放到DatagramPacket包裹中，需要指明目的地
    //4.send()发送
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动中...");
        DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress(10000));
        byte[] bytes = "天地绝杀霸主".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,new InetSocketAddress("localhost",10086));
        datagramSocket.send(datagramPacket);
    }
}
