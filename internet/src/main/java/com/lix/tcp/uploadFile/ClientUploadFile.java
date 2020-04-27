package com.lix.tcp.uploadFile;

import java.io.*;
import java.net.Socket;

public class ClientUploadFile {
    public static void main(String[] args) throws Exception {
        System.out.println("----client----");
        boolean isRunning = true;
        Socket client = new Socket("47.102.153.125", 8889);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        client.setKeepAlive(true);
        sendFile(outputStream);
        client.shutdownOutput();
        receive(inputStream);
        outputStream.close();
        inputStream.close();
    }

    private static void sendFile(OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\Development\\ideaworkspace\\git-source\\javaworld\\internet\\target\\internet-1.0-SNAPSHOT-jar-with-dependencies.jar"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int len = -1;
        byte l[] = new byte[1024];
        while ((len = bufferedInputStream.read(l)) != -1) {
            bufferedOutputStream.write(l, 0, len);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
    }
    private static Object receive(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));

        String s = dataInputStream.readUTF();
        System.out.println(s);
        return s;
    }
}
