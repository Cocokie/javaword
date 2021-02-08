package com.lix;


import lombok.AllArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

 @AllArgsConstructor
public class DownLoadRunnable implements Runnable {
    Map.Entry<Integer, String> urlMap;
    ArrayList errorList;
    TreeMap<Integer, byte []> byteTreeMap ;
    HttpClient httpClient;

    @Override
    public void run() {
        System.out.println("------>"+Thread.currentThread().getName());

        HttpGet httpGet = new HttpGet(urlMap.getValue());
        //httpGet.setHeader("Content-Type", "application/vnd.apple.mpegurl");
        HttpResponse execute = null;
        try {
            execute = httpClient.execute(httpGet);
            System.out.println(urlMap.getValue()+ "        "+ execute.getStatusLine().getStatusCode());
            HttpEntity entity = execute.getEntity();
            InputStream content = entity.getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte []b= new byte[1024];
            int i;
            while((i=content.read(b))!=-1){
                byteArrayOutputStream.write(b,0,i);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteTreeMap.put(urlMap.getKey(),bytes);
            System.out.println("over"+Thread.currentThread().getName());

        } catch (IOException e) {
            errorList.add(urlMap.getValue());
            e.printStackTrace();
        }
    }
}
