package com.lix;

import com.lix.xmlcontainer.ServletClass;
import com.lix.xmlcontainer.WebApp;
import com.lix.xmlparams.WebXmlOperate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: javaworld
 * @description: 控制中心
 * @author: lixin
 * @create: 2020-03-18 16:51
 **/
public class ControlCenter {


    public static void main(String[] args) {
        WebApp webApp = WebXmlOperate.parseXml("myWeb.xml");
        String clazz = webApp.getClazz("/lo");
        System.out.println(clazz);
    }
}
