package com.cszjo.tiffany.spring.support;

import com.cszjo.tiffany.core.config.ProtocolConfig;
import com.cszjo.tiffany.core.config.RegistryConfig;
import com.cszjo.tiffany.core.config.ServerBeanConfig;
import com.cszjo.tiffany.core.config.ServiceConfig;
import com.cszjo.tiffany.spring.support.parse.ProtocolBeanDefinitionParser;
import com.cszjo.tiffany.spring.support.parse.RefererBeanDefinitionParser;
import com.cszjo.tiffany.spring.support.parse.RegistryBeanDefinitionParser;
import com.cszjo.tiffany.spring.support.parse.ServerBeanDefinitionParser;
import com.cszjo.tiffany.spring.support.parse.ServiceBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by hansiming on 2017/10/18.
 */
public class TiffanyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParser(RegistryConfig.class));
        registerBeanDefinitionParser("referer",  new RefererBeanDefinitionParser(RegistryConfig.class));
        registerBeanDefinitionParser("server",   new ServerBeanDefinitionParser(ServerBeanConfig.class));
        registerBeanDefinitionParser("service",  new ServiceBeanDefinitionParser(ServiceConfig.class));
        registerBeanDefinitionParser("protocol",  new ProtocolBeanDefinitionParser(ProtocolConfig.class));
    }
}
