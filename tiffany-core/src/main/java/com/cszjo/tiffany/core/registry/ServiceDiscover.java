package com.cszjo.tiffany.core.registry;

import org.apache.curator.x.discovery.ServiceInstance;

/**
 * Created by hansiming on 2017/10/24.
 */
public interface ServiceDiscover<T> {

    void registerService(ServiceInstance<T> serviceInstance) throws Exception;

    void updateService(ServiceInstance<T> service) throws Exception;

    void unregisterService(ServiceInstance<T> serviceInstance) throws Exception;
}
