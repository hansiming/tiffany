package com.cszjo.tiffany.core.registry;

import com.google.common.collect.Maps;
import org.apache.curator.x.discovery.ServiceInstance;

import java.util.Collection;
import java.util.Map;

/**
 * Created by hansiming on 2017/10/25.
 */
public class AbstractServiceDiscover<T> implements ServiceDiscover<T> {

    protected Map<String, ServiceInstance<T>> serviceMap = Maps.newConcurrentMap();

    @Override
    public void registerService(ServiceInstance<T> serviceInstance) throws Exception {

    }

    @Override
    public void updateService(ServiceInstance<T> service) throws Exception {

    }

    @Override
    public void unregisterService(ServiceInstance<T> serviceInstance) throws Exception {

    }

    @Override
    public Collection<String> queryForNames() throws Exception {
        return null;
    }

    @Override
    public Collection<ServiceInstance<T>> queryInstanceByName(String name) throws Exception {
        return null;
    }
}
