package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.config.RefererConfig;
import com.cszjo.tiffany.core.config.RegistryConfig;
import com.cszjo.tiffany.core.config.ServiceConfig;
import com.cszjo.tiffany.core.contant.ExceptionContant;
import com.cszjo.tiffany.core.contant.ParseContant;
import com.cszjo.tiffany.core.exception.TiffanyParseException;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import static com.google.common.base.Preconditions.*;

/**
 * Created by hansiming on 2017/10/20.
 */
@Deprecated
public class TiffanyBeanDefinitionParser implements BeanDefinitionParser {

    private static final String ADDRESS_REGEXP =  "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))):\\d";
    private static final Logger LOGGER         = LoggerFactory.getLogger(TiffanyBeanDefinitionParser.class);

    private String                          id;
    private Class<? extends AbstractConfig> configClazz;

    public TiffanyBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        this.configClazz = configClazz;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(configClazz);

        if (ServiceConfig.class.equals(configClazz)) {
            parseServiceConfig(element, parserContext, builder);
        } else if (RegistryConfig.class.equals(configClazz)) {
            builder = parseRegistryConfig(element);
        } else if (RefererConfig.class.equals(configClazz)) {

        }

        builder.setLazyInit(false);
        parserContext.getRegistry().registerBeanDefinition(this.id, builder.getBeanDefinition());
        LOGGER.info("create a bean definition, id = {}, bean class = {}",
                this.id, builder.getBeanDefinition().getBeanClassName());
        return builder.getBeanDefinition();
    }

    private BeanDefinition parseServiceConfig(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String interfaceClazz = element.getAttribute(ParseContant.INTERFACE);
        String ref            = element.getAttribute(ParseContant.REF);

        checkAttributeIsNullOrEmpty(interfaceClazz, element.getTagName(), ParseContant.INTERFACE);
        checkAttributeIsNullOrEmpty(ref, element.getTagName(), ParseContant.REF);

        builder.addPropertyValue(ParseContant.INTERFACE_CLASS, interfaceClazz);
        this.id = interfaceClazz;
        addRefBeanDefinition(ref, parserContext, builder);
        return builder.getBeanDefinition();
    }

    private BeanDefinitionBuilder parseRegistryConfig(Element element) {
        String protocol     = element.getAttribute(ParseContant.PROTOCOL);
        String address      = element.getAttribute(ParseContant.ADDRESS);
        Class  serviceClass = RegistryConfig.getServiceDiscoverByEnum(protocol);

        checkAttributeIsNullOrEmpty(protocol, element.getTagName(), ParseContant.PROTOCOL);
        checkAttributeIsNullOrEmpty(address, element.getTagName(), ParseContant.ADDRESS);
        checkProtocolIsExists(serviceClass, protocol);
        checkAddressIsInvalid(address);

        this.id = ParseContant.REGISTRY;
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(serviceClass);
        builder.addPropertyValue(ParseContant.ADDRESS, address);
        builder.setInitMethodName(ParseContant.INIT_METHOD);
        return builder;
    }

    private BeanDefinitionBuilder addRefBeanDefinition(String property, ParserContext parserContext, BeanDefinitionBuilder builder) {
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

    private void checkAttributeIsNullOrEmpty(String property, String elementName, String attributeName) {
        checkArgument(!StringUtils.isBlank(property),
                ExceptionContant.nullOrEmptyMessage, elementName, attributeName);
    }

    private void checkProtocolIsExists(Class clazz, String protocol) {
        checkNotNull(clazz, ExceptionContant.protocolIsNotExistMessage, protocol);
    }

    private void checkAddressIsInvalid(String address) {
        checkArgument(!address.matches(ADDRESS_REGEXP), ExceptionContant.addressIsInvalid, address);
    }
}
