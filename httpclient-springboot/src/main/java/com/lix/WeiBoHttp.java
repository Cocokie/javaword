package com.lix;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WeiBoHttp {
    public static void main(String[] args) throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet();

        for (int i =1;i<=60;i++){

        httpGet.setURI(new URI("https://s.weibo.com/user?q=a&region=custom:43:4&gender=women&page="+i));
        HttpResponse execute = httpClient.execute(httpGet);
        StatusLine statusLine = execute.getStatusLine();

        HttpEntity entity = execute.getEntity();
        String s = EntityUtils.toString(entity);
        Document doc = Jsoup.parse(s);
        Elements elementsByClass = doc.getElementsByClass("card card-user-b s-pg16 s-brt1");
        elementsByClass.forEach(element -> {
            Element info = element.getElementsByClass("info").first();
            Element attr = info.getElementsByAttributeValue("title", "微博会员").first();
            if (attr != null) {
                Element first2 = info.getElementsByAttributeValue("class", "name").first();
                String name = first2.text();
                //
                Element first = info.getElementsByAttributeValue("target", "_blank").last();
                String text = first.text();
                int num = Integer.parseInt(text);
                if (num > 1600) {
                    System.out.println(statusLine.getStatusCode());
                    System.out.println(name+"------>"+first.text());
                }
            }
        });

        }
    }
}
