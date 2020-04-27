package com.lix.tcp.talk;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpTalkClient3 {
    //1.使用DatagramSocket 指定端口，创建发送端
    //2.准备数据，转成byte []形式
    //3.把数据放到DatagramPacket包裹中，需要指明目的地
    //4.send()发送
    public static void main(String[] args) throws IOException {
        System.out.println("----client----");
        Socket client = new Socket("localhost", 8889);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String username = bufferedReader.readLine();
        new Thread(new SendThread(client,username)).start();
        new Thread(new Receive(client)).start();

    }

    static class Receive implements Runnable {
        Socket client;
        InputStream inputStream;

        public Receive(Socket client) throws IOException {
            this.client = client;
            this.inputStream = client.getInputStream();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    dataInputStreamRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        private void dataInputStreamRead() throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            String s = dataInputStream.readUTF();
            System.out.println(s);
        }
    }

    static class SendThread implements Runnable {
        Socket client;
        OutputStream outputStream;
        BufferedReader readerKey;

        public SendThread(Socket client,String username) throws IOException {
            this.client = client;
            this.outputStream = client.getOutputStream();
            this.readerKey = new BufferedReader(new InputStreamReader(System.in));
            send(username);
        }

        @Override

        public void run() {
            while (true) {
                try {
                    String data = readerKey.readLine();
                    send(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void send(String data) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
        }
    }


}
