package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javaworld
 * @description: 测试
 * @author: lixin
 * @create: 2020-03-06 14:35
 **/
public class Customize {
    static HttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws IOException {
        String url = "http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8";
        //String url ="http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/cctv1_2md/1612423141_6120448.ts";
        String prex = url.substring(0, url.lastIndexOf("/") + 1);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/vnd.apple.mpegurl");
        HttpResponse execute = httpClient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        InputStream content = entity.getContent();
        List<Header> headers = Arrays.asList(execute.getAllHeaders());
//        headers.forEach(header->{
//            System.out.println(header.getName()+": "+header.getValue());
//        });
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        String sd;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
        double x = 0;
        Pattern compile = Pattern.compile("^#.+:(),$");
        String contentString = "";
        int i=1;
        try {
            while ((sd = bufferedReader.readLine()) != null) {
                //System.out.println(sd);
                contentString += sd + "\n";
                if (sd.startsWith("#EXTINF")) {
                    Matcher matcher = compile.matcher(sd);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        x = Double.parseDouble(group) + x;
                    }
                }
                if (sd.endsWith(".ts")) {
                    treeMap.put(i++,prex + sd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        //System.out.println(linkedHashSet);
        System.out.println("over");
        ArrayList errorList = new ArrayList<String>();
        TreeMap<Integer, byte []> byteTreeMap = new TreeMap();
        System.out.println(treeMap);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();

        entries.forEach(urlMap->{
            executorService.submit(new DownLoadRunnable(urlMap,errorList,byteTreeMap,httpClient));

        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS); // 或者更长时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(byteTreeMap.size());
        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\git-source\\javaworld\\httpclient-springboot\\cctv.mp4");
        Iterator<Map.Entry<Integer, byte[]>> iterator = byteTreeMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, byte[]> next = iterator.next();
            byte[] value = next.getValue();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value);
            byte []a= new byte[1024];
            int l=0;
            while((l=byteArrayInputStream.read(a))!=-1){
                fileOutputStream.write(a,0,l);
            }
        }

        System.out.println(errorList.size());
    }


}
