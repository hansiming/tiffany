package com.cszjo.tiffany.spring.support.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/20.
 */
public class ServiceBeanDefintionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {

        String interFace = element.getAttribute("interface");
        String ref = element.getAttribute("ref");



        return null;
    }
}
