package com.lix.tcp.uploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作:输入输出流操作
 * 4.释放资源
 */
public class ServerUploadFile {
    public static void main(String[] args) throws Exception {
        System.out.println("----server----");
        ServerSocket serverSocket = new ServerSocket(8889);
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
            try {
                Object receive = receiveFile();
                sendUrl(receive + "   已经接收");
                 close();
            } catch (IOException e) {
                e.printStackTrace();
//            } finally {
//                try {
//                    close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }}

        private Object receiveFile() throws IOException {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("internet/copy.gif"));
            int i = -1;
            byte[] k = new byte[1024];
            while ((i = bufferedInputStream.read(k)) != -1) {
                bufferedOutputStream.write(k, 0, i);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return new File("").getAbsolutePath();
        }

        private void sendUrl(String s) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
            dataOutputStream.writeUTF(s);
            dataOutputStream.flush();
        }


        private void close() throws IOException {
            inputStream.close();
            outputStream.close();
        }

    }

}
