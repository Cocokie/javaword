package com.lix.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpInfo {
    public static void main(String[] args) throws UnknownHostException {

       // getLocalInfo();
        //getInfoByName();
        getInfoByIp();
    }

    private static void getInfoByIp() throws UnknownHostException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        // 返回sxt服务器的IP：59.110.14.7
        System.out.println(addr.getHostAddress());
        /*
         * 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。
         */
        System.out.println(addr.getHostName());
    }

    private static void getInfoByName() throws UnknownHostException {
        InetAddress addr = InetAddress.getByName("www.sxt.cn");
        // 返回 sxt服务器的IP:59.110.14.7
        System.out.println(addr.getHostAddress());
        // 输出：www.sxt.cn
        System.out.println(addr.getHostName());
    }

    private static void getLocalInfo() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        //返回IP地址：192.168.1.110
        System.out.println(addr.getHostAddress());
        //输出计算机名：
        System.out.println(addr.getHostName());
    }
}
