package com.cszjo.tiffany.spring.support;

import com.cszjo.tiffany.core.config.RegistryConfig;
import com.cszjo.tiffany.core.config.ServiceConfig;
import com.cszjo.tiffany.spring.support.parse.TiffanyBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by hansiming on 2017/10/18.
 */
public class TiffanyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("service", new TiffanyBeanDefinitionParser(ServiceConfig.class));
        registerBeanDefinitionParser("registry", new TiffanyBeanDefinitionParser(RegistryConfig.class));
    }
}
