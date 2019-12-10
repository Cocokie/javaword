package com.lix.internet;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SocketIp {
    static HashMap map = new HashMap();
    public static void main(String[] args) throws MalformedURLException {
        int k =8;
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
        File f = new File("E:/images");
        URL url = f.toURI().toURL();
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getProtocol());
        System.out.println(url);
    }
}
