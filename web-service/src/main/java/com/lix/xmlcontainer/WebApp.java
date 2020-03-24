package com.lix.xmlcontainer;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class WebApp {
    private List<ServletClass> servletClasses;
    private List<ServletMapping> servletMappings;
    private Map<String, String> servletMap = null;
    private Map<String, String> servletMappingMap = null;

    public String getClazz(String urlPattern) {
        servletMap = servletClasses.stream().collect(Collectors.toMap(
                servletClass -> servletClass.getServletName(), servletClass -> servletClass.getServletClass()
        ));
        servletMappingMap = new HashMap<>();
        servletMappings.forEach(servletMapping -> {
            servletMapping.getUrlPatterns().forEach(s -> {
                servletMappingMap.put(s, servletMapping.getServletName());
            });

        });
        return servletMap.get(servletMappingMap.get(urlPattern));
    }
}
