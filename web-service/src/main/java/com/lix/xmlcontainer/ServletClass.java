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
public class ServletClass extends XmlInfo {
    private String servletName;
    private String servletClass;
    private List<String> urlPatterns;
}
