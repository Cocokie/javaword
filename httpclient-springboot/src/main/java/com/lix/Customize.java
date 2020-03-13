package com.lix;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: javaworld
 * @description: 测试
 * @author: lixin
 * @create: 2020-03-06 14:35
 **/
public class Customize {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://192.168.1.115/K3API/Token/Create?authorityCode=0444f090b434186bc21c041f6363064db85c31ebdd0676cd");
        HttpResponse execute = httpClient.execute(httpGet);

        String result = EntityUtils.toString(execute.getEntity());

//        HttpGet httpGet1 = new HttpGet("http://192.168.1.115/K3API/Transfer/GetTemplate?token=848C6B7805C23B4A260BA124FB4EF77ABFB5E4920B78E01DD5171BDA7826C6A9B58380774FB690D4");
//        HttpResponse execute1 = httpClient.execute(httpGet1);
//        String result1 = EntityUtils.toString(execute1.getEntity());
        System.out.println(result);
    }
}
