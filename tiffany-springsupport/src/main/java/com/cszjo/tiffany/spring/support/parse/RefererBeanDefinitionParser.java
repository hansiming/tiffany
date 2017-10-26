package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.contant.ParseContant;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by hansiming on 2017/10/26.
 */
public class RefererBeanDefinitionParser extends AbstractBeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefererBeanDefinitionParser.class);

    public RefererBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        super(configClazz);
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id             = element.getAttribute(ParseContant.ID);
        String interfaceClazz = element.getAttribute(ParseContant.INTERFACE);

        checkAttributeIsNullOrEmpty(id, element.getTagName(), ParseContant.ID);
        checkAttributeIsNullOrEmpty(interfaceClazz, element.getTagName(), ParseContant.INTERFACE);

        Class clazz = null;
        Map<String, Method> methodMap = Maps.newHashMap();
        try {
            clazz = Class.forName(interfaceClazz);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                methodMap.put(method.getName(), method);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("the interface '{}' has a error, class not fount!", interfaceClazz);
            throw new IllegalArgumentException("the interface '"
                    + interfaceClazz + "' has a error, class not fount!");
        }

        builder.addPropertyValue(ParseContant.ID, id);
        builder.addPropertyValue(ParseContant.INTERFACE_CLASS, clazz);
        builder.addPropertyValue(ParseContant.METHODS, methodMap);
        parserContext.getRegistry().registerBeanDefinition(id, builder.getBeanDefinition());
        LOGGER.info("create a bean definition, id = {}, bean class = {}",
                this.id, builder.getBeanDefinition().getBeanClassName());
        return builder.getBeanDefinition();
    }
}
