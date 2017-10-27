package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.contant.ExceptionContant;
import com.cszjo.tiffany.core.exception.TiffanyParseException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by hansiming on 2017/10/26.
 */
public abstract class AbstractBeanDefinitionParser implements BeanDefinitionParser {

    private static final String ADDRESS_REGEXP =  "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))):\\d";

    protected String                          id;
    protected Class<? extends AbstractConfig> configClazz;
    protected BeanDefinitionBuilder           builder;

    public AbstractBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        this.configClazz = configClazz;
        builder = BeanDefinitionBuilder.genericBeanDefinition(this.configClazz);
        builder.setLazyInit(false);
    }

    private void checkAttributeIsNullOrEmpty(String property, String elementName, String attributeName) {
        checkArgument(!StringUtils.isBlank(property),
                ExceptionContant.nullOrEmptyMessage, elementName, attributeName);
    }

    protected void checkProtocolIsExists(Class clazz, String protocol) {
        checkNotNull(clazz, ExceptionContant.protocolIsNotExistMessage, protocol);
    }

    protected void checkAddressIsInvalid(String address) {
        checkArgument(!address.matches(ADDRESS_REGEXP), ExceptionContant.addressIsInvalid, address);
    }

    protected BeanDefinitionBuilder addRefBeanDefinition(String property, String paramName, ParserContext parserContext, BeanDefinitionBuilder builder) {
        if (parserContext.getRegistry().containsBeanDefinition(property)) {
            BeanDefinition refDefinition = parserContext.getRegistry().getBeanDefinition(property);
            if (!refDefinition.isSingleton()) {
                throw new TiffanyParseException("The exported service ref " + property + " must be singleton! Please set the " + property
                        + " bean scope to singleton, eg: <bean id=\"" + property + "\" scope=\"singleton\" ...>");
            }
            builder.addPropertyValue(paramName, new RuntimeBeanReference(property));
        }
        return builder;
    }

    protected String getAttributeNameByElement(String property, Element element) {
        String attr = element.getAttribute(property);
        checkAttributeIsNullOrEmpty(attr, element.getTagName(), property);
        return attr;
    }
}
