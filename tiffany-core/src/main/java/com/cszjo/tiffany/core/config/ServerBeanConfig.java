package com.cszjo.tiffany.core.config;

import com.cszjo.tiffany.core.registry.AbstractServiceDiscover;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by hansiming on 2017/10/27.
 */
public class ServerBeanConfig extends AbstractConfig {

    private AbstractServiceDiscover serviceDiscover;
    private List<ServiceConfig>     services = Lists.newArrayList();

    public AbstractServiceDiscover getServiceDiscover() {
        return serviceDiscover;
    }

    public void setServiceDiscover(AbstractServiceDiscover serviceDiscover) {
        this.serviceDiscover = serviceDiscover;
    }

    public List<ServiceConfig> getServices() {
        return services;
    }

    public void setServices(List<ServiceConfig> services) {
        this.services = services;
    }
}
