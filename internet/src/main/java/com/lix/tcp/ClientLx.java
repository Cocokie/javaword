package com.lix.tcp;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-02-27 17:52
 **/

import java.io.*;
import java.net.Socket;

/**
 * 创建服务器
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作:输入输出流操作
 * 3.释放资源
 */
public class ClientLx {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1; i++) {
            System.out.println("----client----");
            Socket client = new Socket("localhost", 8889);
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data = "hello";
            dos.writeUTF(data);
            dos.flush();
            client.shutdownOutput();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("s");
                System.out.println(line);
            }
            dos.close();
            bufferedReader.close();
            // dos.close();
        }
    }
}
