package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.contant.ParseContant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/27.
 */
public class ServerBeanDefinitionParser extends AbstractBeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerBeanDefinitionParser.class);

    public ServerBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        super(configClazz);
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id       = getAttributeNameByElement(ParseContant.ID, element);
        String registry = getAttributeNameByElement(ParseContant.REGISTRY, element);

        addRefBeanDefinition(registry, ParseContant.SERVICE_DISCOVER, parserContext, builder);
        parserContext.getRegistry().registerBeanDefinition(id, builder.getBeanDefinition());
        LOGGER.info("create a bean definition, id = {}, bean class = {}",
                id, builder.getBeanDefinition().getBeanClassName());
        return builder.getBeanDefinition();
    }
}
