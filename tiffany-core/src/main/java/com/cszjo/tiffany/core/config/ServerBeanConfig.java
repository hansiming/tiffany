package com.cszjo.tiffany.core.config;

import com.cszjo.tiffany.core.registry.AbstractServiceDiscover;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by hansiming on 2017/10/27.
 */
public class ServerBeanConfig extends AbstractConfig {

    private AbstractServiceDiscover serviceDiscover;
    private Set<ServiceConfig> services = Sets.newHashSet();

    public AbstractServiceDiscover getServiceDiscover() {
        return serviceDiscover;
    }

    public void setServiceDiscover(AbstractServiceDiscover serviceDiscover) {
        this.serviceDiscover = serviceDiscover;
    }

    public Set<ServiceConfig> getServices() {
        return services;
    }

    public void setServices(Set<ServiceConfig> services) {
        this.services = services;
    }

    public void start() {

    }
}
