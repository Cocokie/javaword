package com.lix.tcp.basictalk;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-02-27 17:52
 **/

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 创建服务器
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作:输入输出流操作
 * 3.释放资源
 */
public class ClientLx2 {
    public static void main(String[] args) throws Exception {
        System.out.println("----client----");
        boolean isRunning =true;
        Socket client = new Socket("localhost", 13000);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        BufferedReader readerKey = new BufferedReader(new InputStreamReader(System.in));

        while (isRunning) {
            String data = readerKey.readLine();
            outPutStreamRead(outputStream, data);
            InputStreamRead(inputStream);
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

    private static void InputStreamRead(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] b = new byte[1024];
        int k = -1;
        while ((k = bufferedInputStream.read(b)) != -1) {
            System.out.println(new String(b, 0, k));
        }
    }
    private static void outPutStreamRead(OutputStream outputStream,String data) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(data.getBytes());
        bufferedOutputStream.flush();
    }
}
