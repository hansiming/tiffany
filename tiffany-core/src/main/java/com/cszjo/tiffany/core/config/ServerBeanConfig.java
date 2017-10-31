package com.cszjo.tiffany.core.config;

import com.cszjo.tiffany.core.exception.TiffanyServerException;
import com.cszjo.tiffany.core.registry.AbstractServiceDiscover;
import com.cszjo.tiffany.core.util.NetUtils;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.curator.x.discovery.ServiceInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;

/**
 * Created by hansiming on 2017/10/27.
 */
public class ServerBeanConfig extends AbstractConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerBeanConfig.class);

    private AbstractServiceDiscover serviceDiscover;
    private Set<ServiceConfig>      services;

    public ServerBeanConfig() {
        services = Sets.newHashSet();
    }

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

    /**
     * 启动TiffanyServer
     */
    public void start() {
        if (services == null || services.isEmpty()) {
            LOGGER.error("start server has a error, service config is null or empty");
            throw new TiffanyServerException("start server has a error, service config is null or empty");
        }
        try {
            for (ServiceConfig sc : services) {
                Integer port = sc.getPort();
                ServiceInstance instance = ServiceInstance.builder().name(sc.getServerId()).port(port)
                        .address(NetUtils.getLocalAddress().getHostAddress()).build();
                serviceDiscover.registerService(instance);
            }
        } catch (Exception e) {
            LOGGER.error("can`t get ServiceInstance, e = {}", e);
        }
    }
}
