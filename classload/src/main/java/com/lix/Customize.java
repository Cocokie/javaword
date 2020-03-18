package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-11 10:32
 **/
@Data
public class Customize {
    static {
        System.out.println("Customize 被加载了");
    }

    public static void main(String[] args) throws Exception {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

    }

}
