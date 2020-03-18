package com.lix;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum XmlInfoConstant {

    SERVLET("servlet"),

    SERVLETMAPPING("servlet-mapping");


    private String name;
}
