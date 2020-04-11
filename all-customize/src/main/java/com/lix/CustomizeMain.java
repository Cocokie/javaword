package com.lix;

import java.io.*;
import java.util.Scanner;

/**
 * @author 12547
 */
public class CustomizeMain {
    public static void main(String[] args) throws IOException {
//        InputStream in = System.in;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hahah".getBytes());
        Scanner s = new Scanner(byteArrayInputStream);
        System.out.println(s.next());
       // System.out.println(br.readLine());
    }
}
