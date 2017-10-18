package com.cszjo.tiffany.spring.support;

import com.cszjo.tiffany.spring.support.parse.StudentBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by hansiming on 2017/10/18.
 */
public class TiffanyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
    }
}
