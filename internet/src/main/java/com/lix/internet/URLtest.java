package com.lix.internet;

import java.net.MalformedURLException;
import java.net.URL;

public class URLtest {
    public static void main(String[] args) throws MalformedURLException {
        URL u = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
        System.out.println("获取与此url关联的协议的默认端口：" + u.getDefaultPort());
        System.out.println("getFile:" + u.getFile()); // 端口号后面的内容
        System.out.println("主机名：" + u.getHost()); // www.google.cn
        System.out.println("路径：" + u.getPath()); // 端口号后，参数前的内容
        // 如果www.google.cn:80则返回80.否则返回-1
        System.out.println("端口：" + u.getPort());
        System.out.println("协议：" + u.getProtocol());
        System.out.println("参数部分：" + u.getQuery());
        System.out.println("锚点：" + u.getRef());

        URL u1 = new URL("http://www.abc.com/aa/");
        URL u2 = new URL(u, "2.html"); // 相对路径构建url对象
        System.out.println(u2.toString()); // http://www.abc.com/aa/2.html
    }
}
