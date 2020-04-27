package com.lix;

import java.io.*;
import java.net.Socket;

public class clientTst {
    public static void main(String[] args) throws IOException {
        System.out.println("----client----");
        BufferedReader readerKey = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket("localhost", 8889);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();

        String s = readerKey.readLine();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(s.getBytes());
        bufferedOutputStream.flush();
        client.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

}
