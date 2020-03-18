package com.lix.xmlparams;

import com.lix.XmlInfoConstant;
import com.lix.xmlcontainer.ServletClass;
import com.lix.xmlcontainer.ServletMapping;
import com.lix.xmlcontainer.XmlInfo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-18 17:00
 **/
public class WebXmlOperate implements XmlParse {
    private List<Map<String, Object>> xmlObjects;

    public List<Map<String, List<Object>>> parseXml(String resource) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            WebXmlParseHandler webXmlParseHandler = new WebXmlParseHandler();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource), webXmlParseHandler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Map<String, Object>> getXmlObjects() {
        return xmlObjects;
    }
}

class WebXmlParseHandler extends DefaultHandler {
    private List<Map<String, List<XmlInfo>>> xmlInfo;
    private ServletClass servletClass;
    private ServletMapping servletMapping;
    private Map<String, List<XmlInfo>> map;
    private String currentTag;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析webXml");
        xmlInfo = new ArrayList<Map<String, List<XmlInfo>>>();
        map = new HashMap<String, List<XmlInfo>>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("开始解析元素");
        this.currentTag = qName;
        if (qName != null && qName.equals(XmlInfoConstant.SERVLET)) {
            servletClass = new ServletClass();
        } else if (qName != null && qName.equals(XmlInfoConstant.SERVLETMAPPING)) {
            servletMapping = new ServletMapping();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("解析元素内容");
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("解析元素结束");
        super.endElement(uri, localName, qName);
    }


    @Override
    public void endDocument() throws SAXException {
        System.out.println("webXml解析完毕");

    }

}
