package com.lix.udp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//udp本来是不分服务端和客户端的，一般都是互相自由通信
//此测试就当此类为接收端
public class UdpObjServer {
   //1.使用DatagramSocket 指定端口，创建接收端
   //2.准备容器用来装发送的数据，  封装成DatagramPacket来装数据
   //3.阻塞式接受数据包裹
   //4.分析数据
    //5.释放资源
    public static void main(String[] args) throws Exception {
//创建数据报套接字：指定接收信息的端口
        DatagramSocket ds = new DatagramSocket(8999);
        byte[] b = new byte[1024];
        //创建数据报包，指定要接收的数据的缓存位置和长度
        DatagramPacket dp = new DatagramPacket(b, b.length);
        //接收客户端发送的数据报
        ds.receive(dp); // 阻塞式方法
        //dp.getData():获取客户端发送的数据，返回值是一个字节数组
        ByteArrayInputStream bis = new ByteArrayInputStream(dp.getData());
        ObjectInputStream ois = new ObjectInputStream(bis);
        System.out.println(ois.readObject());
        //关闭资源
        ois.close();
        bis.close();
        ds.close();
    }
}
