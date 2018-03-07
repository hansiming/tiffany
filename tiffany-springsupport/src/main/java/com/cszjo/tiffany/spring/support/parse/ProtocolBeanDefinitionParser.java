package com.cszjo.tiffany.spring.support.parse;

import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.contant.ParseContant;
import com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import static com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum.ActiveWeight;
import static com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum.ConfigurableWeight;
import static com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum.Consistent;
import static com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum.Random;
import static com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum.RoundRobin;

/**
 * Created by hansiming on 2018/3/7.
 */
public class ProtocolBeanDefinitionParser extends AbstractBeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBeanDefinitionParser.class);

    public ProtocolBeanDefinitionParser(Class<? extends AbstractConfig> configClazz) {
        super(configClazz);
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        id = getAttributeNameByElement(ParseContant.ID, element);
        String name = getAttributeNameByElement(ParseContant.NAME, element);
        LoadBalanceEnum loadBalance = element.getAttribute(ParseContant.LOAD_BALANCE) == null ? ActiveWeight : getLoadBalance(element.getAttribute(ParseContant.LOAD_BALANCE));

        builder.addPropertyValue(ParseContant.NAME, name);
        builder.addPropertyValue(ParseContant.LOAD_BALANCE, loadBalance);
        parserContext.getRegistry().registerBeanDefinition(id, builder.getBeanDefinition());
        LOGGER.info("create a bean definition, id = {}, bean class = {}",
                this.id, builder.getBeanDefinition().getBeanClassName());
        return builder.getBeanDefinition();
    }

    public LoadBalanceEnum getLoadBalance(String type) {
        switch (type) {
            case "ActiveWeight": return ActiveWeight;
            case "Random": return Random;
            case "RoundRobin": return RoundRobin;
            case "Consistent": return Consistent;
            case "ConfigurableWeight": return ConfigurableWeight;
            default: throw new IllegalArgumentException("can not find load balance: " + type);
        }
    }
}
