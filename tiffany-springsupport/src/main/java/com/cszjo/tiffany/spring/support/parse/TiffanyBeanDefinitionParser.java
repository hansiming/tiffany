package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.config.ServiceConfig;
import com.cszjo.tiffany.core.exception.TiffanyParseException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by hansiming on 2017/10/20.
 */
public class TiffanyBeanDefinitionParser implements BeanDefinitionParser {

    private Class<? extends AbstractConfig> configClazz;
    private String id;

    public TiffanyBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        this.configClazz = configClazz;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(configClazz);

        if (ServiceConfig.class.equals(configClazz)) {
            parseServiceConfig(element, parserContext, builder);
        }

        parserContext.getRegistry().registerBeanDefinition(this.id, builder.getBeanDefinition());

        return builder.getBeanDefinition();
    }

    private BeanDefinition parseServiceConfig(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String interfaceClazz = element.getAttribute("interface");
        String ref = element.getAttribute("ref");
        if (!StringUtils.isBlank(interfaceClazz)) {
            builder.addPropertyValue("interfaceClazz", interfaceClazz);
            this.id = interfaceClazz;
        } else {
            throw new TiffanyParseException("The exported service 'interface' property can`t be null or empty!");
        }
        addRefBeanDefinition(ref, parserContext, builder);
        return builder.getBeanDefinition();
    }

    private BeanDefinitionBuilder addRefBeanDefinition(String property, ParserContext parserContext, BeanDefinitionBuilder builder) {
        if (StringUtils.isBlank(property)) {
            throw new TiffanyParseException("The exported service 'ref' property can`t be null or empty!");
        }
        if (parserContext.getRegistry().containsBeanDefinition(property)) {
            BeanDefinition refDefinition = parserContext.getRegistry().getBeanDefinition(property);
            if (!refDefinition.isSingleton()) {
                throw new TiffanyParseException("The exported service ref " + property + " must be singleton! Please set the " + property
                        + " bean scope to singleton, eg: <bean id=\"" + property + "\" scope=\"singleton\" ...>");
            }
            builder.addPropertyValue("ref", new RuntimeBeanReference(property));
        }
        return builder;
    }
}
