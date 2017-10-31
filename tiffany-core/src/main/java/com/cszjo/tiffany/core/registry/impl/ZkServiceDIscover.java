package com.cszjo.tiffany.core.registry.impl;

import com.cszjo.tiffany.core.config.ServiceInstanceMetaInfo;
import com.cszjo.tiffany.core.contant.ServiceInstanceContant;
import com.cszjo.tiffany.core.registry.AbstractServiceDiscover;
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

import java.util.Collection;

/**
 * Zookeeper 服务发现
 * Created by hansiming on 2017/10/24.
 */
public class ZkServiceDiscover extends AbstractServiceDiscover<ServiceInstanceMetaInfo> implements TreeCacheListener {

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

    @Override
    public void registerService(ServiceInstance<ServiceInstanceMetaInfo> service) throws Exception {
        serviceDiscover.registerService(service);
    }

    @Override
    public void updateService(ServiceInstance<ServiceInstanceMetaInfo> service) throws Exception {
        serviceDiscover.updateService(service);
    }

    @Override
    public void unregisterService(ServiceInstance<ServiceInstanceMetaInfo> service) throws Exception {
        serviceDiscover.unregisterService(service);
    }

    @Override
    public Collection<String> queryForNames() throws Exception {
        return serviceDiscover.queryForNames();
    }

    @Override
    public Collection<ServiceInstance<ServiceInstanceMetaInfo>> queryInstanceByName(String name) throws Exception {
        return serviceDiscover.queryForInstances(name);
    }

    @Override
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        ChildData data = treeCacheEvent.getData();
//        ServiceInstance serviceInstance = serializer.deserialize(data.getData());
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

    @Override
    public String toString() {
        return "ZkServiceDiscover{" +
                "address='" + address + '\'' +
                ", serviceDiscover=" + serviceDiscover +
                ", serializer=" + serializer +
                '}';
    }
}
