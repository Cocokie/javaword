package com.lix.tcp.basictalk;

/**
 * @program: javaworld
 * @description: tcp服务器
 * @author: lixin
 * @create: 2020-02-27 17:44
 **/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作:输入输出流操作
 * 4.释放资源
 */
public class ServerLx {
    public static void main(String[] args) throws Exception {
        System.out.println("----server----");
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true) {
            Socket server = serverSocket.accept();

            System.out.println("一个客户端建立了连接");

            new Thread(new Channel(server)).start();
        }
    }

    static class Channel implements Runnable {
        Socket socketServer;
        InputStream inputStream;
        OutputStream outputStream;

        public Channel(Socket server) throws IOException {
            this.socketServer = server;
            this.inputStream = server.getInputStream();
            this.outputStream = server.getOutputStream();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Object receive = receive();
                    send(receive + "   已经接收");
                    // close();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        private Object send(String data) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
            return data;
        }

        private Object receive() throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            String s = dataInputStream.readUTF();
            System.out.println(s);
            return s;
        }

        private void close() throws IOException {
            inputStream.close();
            outputStream.close();
        }


        private void send2(String data) throws IOException {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(data.getBytes());
            bufferedOutputStream.flush();
        }

        private String receive2() throws IOException {
            String line = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("读取中");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("===============over==============");

            return line;
        }
    }
}
