package com.lix.tcp;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-02-27 17:52
 **/

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 创建服务器
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作:输入输出流操作
 * 3.释放资源
 */
public class ClientLx {
    public static void main(String[] args) throws Exception {
        System.out.println("----client----");
        Socket client = new Socket("localhost",8888);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);

        dos.flush();
        dos.close();
    }
}
