package com.lix;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum XmlInfoConstant {

    SERVLET("servlet"),

    SERVLETMAPPING("servlet-mapping"),
    SERVLETNAME("servlet-name"),
    SERVLETCLASS("servlet-class"),
    URLPATTERN("url-pattern"),
    WEBAPP("web-app");
    private String name;
}
