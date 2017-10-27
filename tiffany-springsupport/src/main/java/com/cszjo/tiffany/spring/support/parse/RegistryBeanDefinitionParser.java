package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.config.RegistryConfig;
import com.cszjo.tiffany.core.contant.ParseContant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/26.
 */
public class RegistryBeanDefinitionParser extends AbstractBeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistryBeanDefinitionParser.class);

    public RegistryBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        super(configClazz);
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String protocol     = getAttributeNameByElement(ParseContant.PROTOCOL, element);
        String address      = getAttributeNameByElement(ParseContant.ADDRESS, element);
        Class  serviceClass = RegistryConfig.getServiceDiscoverByEnum(protocol);

        checkProtocolIsExists(serviceClass, protocol);
        checkAddressIsInvalid(address);

        this.id = ParseContant.REGISTRY;
        builder = BeanDefinitionBuilder.genericBeanDefinition(serviceClass);
        builder.addPropertyValue(ParseContant.ADDRESS, address);
        builder.setInitMethodName(ParseContant.INIT_METHOD);
        builder.setLazyInit(false);
        parserContext.getRegistry().registerBeanDefinition(this.id, builder.getBeanDefinition());
        LOGGER.info("create a bean definition, id = {}, bean class = {}",
                this.id, builder.getBeanDefinition().getBeanClassName());
        return builder.getBeanDefinition();
    }
}
