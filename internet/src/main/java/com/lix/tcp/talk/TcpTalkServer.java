package com.lix.tcp.talk;

import lombok.Data;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//udp本来是不分服务端和客户端的，一般都是互相自由通信
//此测试就当此类为接收端
public class TcpTalkServer {
    public static void main(String[] args) throws Exception {
        CopyOnWriteArrayList<Channel> channelList = new CopyOnWriteArrayList<Channel>();
        System.out.println("----server----");
        ServerSocket serverSocket = new ServerSocket(8889);

        while (true) {
            Socket server = serverSocket.accept();
            Channel channel = new Channel(server, channelList);
            channelList.add(channel);
            System.out.println("一个客户端建立了连接");
            new Thread(channel).start();

        }
    }

    @Data
    static class Channel implements Runnable {
        List<Channel> channelList;
        Socket socketServer;
        InputStream inputStream;
        OutputStream outputStream;
        String username;

        public Channel(Socket server, List<Channel> channelList) throws IOException {
            this.channelList = channelList;
            this.socketServer = server;
            this.inputStream = server.getInputStream();
            this.outputStream = server.getOutputStream();
            this.username = receive();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String receive = receive();
                    sendOthers(receive,false);
                    //send(receive + "   已经接收");
                    // close();
                } catch (IOException e) {
                    try {
                        close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        }

        private Object sendOthers(String data, boolean sysFlag) throws IOException {
            for (Channel channel : channelList) {
                if (channel != this) {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(channel.getOutputStream()));
                    if (sysFlag) {
                        dataOutputStream.writeUTF(data);
                    } else {
                        dataOutputStream.writeUTF(username + ":" + data);

                    }

                    dataOutputStream.flush();
                }
            }

            return data;
        }

        private String receive() throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
            String s = dataInputStream.readUTF();
            System.out.println(s);
            return s;
        }

        private void close() throws IOException {
            inputStream.close();
            outputStream.close();
            channelList.remove(this);
            sendOthers(username + "离开了",true);
        }

    }
}
