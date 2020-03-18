package com.lix.xmlparams;

import com.lix.domain.Person;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-18 14:54
 **/
public class XmlOperate {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        HHandler hHandler = new HHandler();
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("my.xml"), hHandler);
        List<Person> persons = hHandler.getPersons();
        System.out.println(persons);
    }

}

class HHandler extends DefaultHandler {
    List<Person> persons;
    Person person;
    String currentTag;

    @Override

    public void startDocument() throws SAXException {
        System.out.println("======解析XML开始======");
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("解析元素开始：-> " + qName);
        System.out.println("属性：->" + attributes.getValue(0));
        this.currentTag = qName;
        if (qName != null && qName.equals("person")) {
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        System.out.println("characters:-> " + s);
        if (StringUtils.isNotBlank(s) && person != null) {
            if (currentTag.equals("name")) {
                person.setName(s);
            } else if (currentTag.equals("age")) {
                person.setAge(Integer.valueOf(s));
            } else if (currentTag.equals("description")) {
                person.setDescription(s);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("解析元素结束：-> " + qName);
        if (qName != null && qName.equals("person")) {
            persons.add(person);
            person = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("======解析XML结束======");
        System.out.println(persons);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
