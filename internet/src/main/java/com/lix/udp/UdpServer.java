package com.lix.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//udp本来是不分服务端和客户端的，一般都是互相自由通信
//此测试就当此类为接收端
public class UdpServer {
   //1.使用DatagramSocket 指定端口，创建接收端
   //2.准备容器用来装发送的数据，  封装成DatagramPacket来装数据
   //3.阻塞式接受数据包裹receive(DatagramPacket p)
   //4.分析数据
    //5.释放资源
    public static void main(String[] args) throws Exception {
        byte []a = new byte[1000];
        System.out.println("接收端启动中....");
        DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress(10086));
        DatagramPacket datagramPacket = new DatagramPacket(new byte[2048*20],2048);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data));
    }
}
