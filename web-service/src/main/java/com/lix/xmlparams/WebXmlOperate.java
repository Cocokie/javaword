package com.lix.xmlparams;

import com.lix.XmlInfoConstant;
import com.lix.xmlcontainer.ServletClass;
import com.lix.xmlcontainer.ServletMapping;
import com.lix.xmlcontainer.WebApp;
import com.lix.xmlcontainer.XmlInfo;
import org.apache.commons.lang3.StringUtils;
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
public class WebXmlOperate {


    public static WebApp parseXml(String resource) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        WebApp webApp = null;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            WebXmlParseHandler webXmlParseHandler = new WebXmlParseHandler();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource), webXmlParseHandler);
             webApp = webXmlParseHandler.getWebApp();
            System.out.println(webApp);
            System.out.println("======解析完毕======");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return webApp;
    }

    public static WebApp getWebApp(String resource) {
        if (StringUtils.isBlank(resource)) {
            return new WebApp();
        }
        return parseXml(resource);
    }
}

class WebXmlParseHandler extends DefaultHandler {
    private ServletClass servletClass;
    private ServletMapping servletMapping;
    private WebApp webApp;
    private String currentTag;
    private List<ServletClass> servletClassList;
    private List<ServletMapping> servletMappingList;
    private List<String> urlPatterns;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析webXml");
        servletClassList = new ArrayList<ServletClass>();
        servletMappingList = new ArrayList<ServletMapping>();
        webApp = new WebApp();
        urlPatterns = new ArrayList<String>();

    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("开始解析元素");
        this.currentTag = qName;
        if (qName != null && qName.equals(XmlInfoConstant.SERVLET.getName())) {
            servletClass = new ServletClass();
        } else if (qName != null && qName.equals(XmlInfoConstant.SERVLETMAPPING.getName())) {
            servletMapping = new ServletMapping();
            servletMapping.setUrlPatterns(urlPatterns);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("解析元素内容");
        String s = new String(ch, start, length).trim();
        if (servletClass != null && currentTag != null) {
            if (currentTag.equals(XmlInfoConstant.SERVLETNAME.getName())) {
                servletClass.setServletName(s);
            } else if (currentTag.equals(XmlInfoConstant.SERVLETCLASS.getName())) {
                servletClass.setServletClass(s);
            }

        } else if (servletMapping != null && currentTag != null) {
            if (currentTag.equals(XmlInfoConstant.SERVLETNAME.getName())) {
                servletMapping.setServletName(s);
            } else if (currentTag.equals(XmlInfoConstant.URLPATTERN.getName())) {
                urlPatterns.add(s);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("解析元素结束");
        currentTag = null;
        if (qName != null && qName.equals(XmlInfoConstant.WEBAPP.getName())) {
            webApp.setServletClasses(servletClassList);
            webApp.setServletMappings(servletMappingList);
        } else if (qName != null && qName.equals(XmlInfoConstant.SERVLET.getName())) {
            servletClassList.add(servletClass);
            for (ServletMapping mapping : servletMappingList) {
                if (mapping.getServletName().equals(servletClass.getServletName())) {
                    servletClass.setUrlPatterns(mapping.getUrlPatterns());
                }
            }
            servletClass = null;
        } else if (qName != null && qName.equals(XmlInfoConstant.SERVLETMAPPING.getName())) {
            servletMappingList.add(servletMapping);
            for (ServletClass servletClass : servletClassList) {
                if (servletClass.getServletName().equals(servletMapping.getServletName())) {
                    servletClass.setUrlPatterns(servletMapping.getUrlPatterns());
                }
            }
            urlPatterns = new ArrayList<String>();
            servletMapping = null;
        }
        super.endElement(uri, localName, qName);
    }


    @Override
    public void endDocument() throws SAXException {
        System.out.println("webXml解析完毕");
    }

    public WebApp getWebApp() {
        return webApp;
    }
}
