package com.lix.xmlcontainer;

import lombok.Data;

import java.util.List;

@Data
public class WebApp {
    List<ServletClass> servletClasses;
    List<ServletMapping> servletMappings;
}
