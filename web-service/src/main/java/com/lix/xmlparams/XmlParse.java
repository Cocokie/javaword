package com.lix.xmlparams;

import java.util.List;
import java.util.Map;

public interface XmlParse {
    List<Map<String, List<Object>>> parseXml(String resource);
}
