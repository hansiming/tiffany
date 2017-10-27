package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.contant.ParseContant;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/27.
 */
public class ServiceBeanDefinitionParser extends AbstractBeanDefinitionParser {

    public ServiceBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        super(configClazz);
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id                  = getAttributeNameByElement(ParseContant.ID, element);
        String serverId            = getAttributeNameByElement(ParseContant.SERVER, element);
        String ref                 = getAttributeNameByElement(ParseContant.REF, element);
        String interfaceClazz      = getAttributeNameByElement(ParseContant.INTERFACE, element);
        ApplicationContext context = (ApplicationContext) parserContext.getReaderContext().getReader().getResourceLoader();

        builder.addPropertyValue(ParseContant.ID, id);
        builder.addPropertyValue(ParseContant.INTERFACE_CLASS, interfaceClazz);
        builder.addPropertyValue(ParseContant.SERVER_ID, serverId);
        builder.addPropertyValue(ParseContant.CONTEXT, context);
        builder.setInitMethodName(ParseContant.INIT_METHOD);
        addRefBeanDefinition(ref, ParseContant.REF, parserContext, builder);
        parserContext.getRegistry().registerBeanDefinition(id, builder.getBeanDefinition());
        return builder.getBeanDefinition();
    }
}
