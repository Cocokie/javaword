package com.lix.xmlcontainer;

import lombok.Data;

import java.util.List;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-18 17:15
 **/
@Data
public class ServletMapping extends XmlInfo{
    private String servletName;
    private List<String> urlPatterns;
}
