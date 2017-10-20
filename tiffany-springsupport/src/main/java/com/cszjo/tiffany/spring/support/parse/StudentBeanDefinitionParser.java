package com.cszjo.tiffany.spring.support.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/18.
 */
public class StudentBeanDefinitionParser implements BeanDefinitionParser {

    private final static String STUDENT_ID = "id";
    private final static String STUDENT_NAME = "name";

    public BeanDefinition parse(Element element, ParserContext parserContext) {

//        String id = element.getAttribute(STUDENT_ID);
//        String name = element.getAttribute(STUDENT_NAME);
//
////        ApplicationContext context = (ApplicationContext)parserContext.getReaderContext().getReader().getResourceLoader();
//        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);
//        builder.addPropertyValue("id", id);
//        builder.addPropertyValue("name", name);
//
//        parserContext.getRegistry().registerBeanDefinition("student", builder.getBeanDefinition());

        return null;
    }
}
