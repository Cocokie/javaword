package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: javaworld
 * @description: 测试
 * @author: lixin
 * @create: 2020-03-06 14:35
 **/
public class Customize {
    static HttpClient httpClient = HttpClients.createDefault();
    static String token;

    public static void main(String[] args) throws IOException {
        token = getToken();

//        HttpGet httpGet1 = new HttpGet("http://192.168.1.115/K3API/Transfer/GetTemplate?token=848C6B7805C23B4A260BA124FB4EF77ABFB5E4920B78E01DD5171BDA7826C6A9B58380774FB690D4");
//        HttpResponse execute1 = httpClient.execute(httpGet1);
//        String result1 = EntityUtils.toString(execute1.getEntity());
        //add();
        String url = String.format("http://192.168.1.115/K3API/Bill1000022/GetList?Token=%s", token);
        RequestConfig.custom().build();
        HttpPost httpPost = new HttpPost(url);

        String params = "{\"Data\":{\"FBillNo\":\"001\"}}";
        StringEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        HttpResponse execute = httpClient.execute(httpPost);
        String result = EntityUtils.toString(execute.getEntity());
        System.out.println(result);
    }

    private static void add() throws IOException {
        String url = String.format("http://192.168.1.115/K3API/Bill1000022/Save?Token=%s", token);
        System.out.println(url);
        HttpPost httpPost = new HttpPost(url);
        FileInputStream fileInputStream = new FileInputStream("httpclient-springboot/JSON.txt");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] k = new byte[1024 * 5];
        int i = -1;
        while ((i = fileInputStream.read(k)) != -1) {
            byteArrayOutputStream.write(k, 0, i);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String params = new String(bytes, "gbk");
        // System.out.println(new String(bytes,"gbk"))
        StringEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        HttpResponse execute = httpClient.execute(httpPost);
        String result = EntityUtils.toString(execute.getEntity());
        System.out.println(result);
    }

    private static String getToken() throws IOException {
        HttpGet httpGet = new HttpGet("http://192.168.1.115/K3API/Token/Create?authorityCode=0444f090b434186bc21c041f6363064db85c31ebdd0676cd");
        HttpResponse execute = httpClient.execute(httpGet);
        String s = EntityUtils.toString(execute.getEntity());
        JSONObject object = JSON.parseObject(s);
        if (200 == object.getInteger("StatusCode")) {
            JSONObject data = object.getJSONObject("Data");
            return (String) data.get("Token");
        }
        return "";
    }
}
