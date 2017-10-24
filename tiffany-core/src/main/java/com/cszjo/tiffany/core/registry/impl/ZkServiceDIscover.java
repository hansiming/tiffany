package com.cszjo.tiffany.core.registry.impl;

import com.cszjo.tiffany.core.config.ServiceInstanceMetaInfo;
import com.cszjo.tiffany.core.contant.ServiceInstanceContant;
import com.cszjo.tiffany.core.registry.ServiceDiscover;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.InstanceSerializer;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

/**
 * Created by hansiming on 2017/10/24.
 */
public class ZkServiceDIscover<T> implements ServiceDiscover<T>, TreeCacheListener {

    private String                                      address;
    private ServiceDiscovery<ServiceInstanceMetaInfo>   serviceDiscover;
    private InstanceSerializer<ServiceInstanceMetaInfo> serializer;

    public void start() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory
                .newClient(address, new ExponentialBackoffRetry(1000, 3));
        client.start();
        serializer = new JsonInstanceSerializer<>(ServiceInstanceMetaInfo.class);
        this.serviceDiscover = ServiceDiscoveryBuilder.builder(ServiceInstanceMetaInfo.class)
                .basePath(ServiceInstanceContant.BASE_PATH)
                .client(client)
                .serializer(serializer)
                .build();
        this.serviceDiscover.start();
        TreeCache cache = new TreeCache(client, ServiceInstanceContant.BASE_PATH);
        cache.getListenable().addListener(this);
        cache.start();
    }

    public void registerService(ServiceInstance<T> serviceInstance) throws Exception {

    }

    public void updateService(ServiceInstance<T> service) throws Exception {

    }

    public void unregisterService(ServiceInstance<T> serviceInstance) throws Exception {

    }

    @Override
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        ChildData data = treeCacheEvent.getData();
        ServiceInstance serviceInstance = serializer.deserialize(data.getData());
        switch (treeCacheEvent.getType()) {
            case NODE_ADDED: {
                break;
            }
            case NODE_UPDATED: {
                break;
            }
            case NODE_REMOVED: {
                break;
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
