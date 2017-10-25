package com.cszjo.tiffany.core.config;

import com.cszjo.tiffany.core.registry.impl.ZkServiceDiscover;

/**
 * Created by hansiming on 2017/10/25.
 */
public class RegistryConfig extends AbstractConfig {

    private String protocol;
    private String address;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    enum RegistryEnum{
        zookeeper(ZkServiceDiscover.class);

        private Class clazz;

        RegistryEnum(Class clazz) {
            this.clazz = clazz;
        }

        public Class getClazz() {
            return clazz;
        }
    }

    public static Class getServiceDiscoverByEnum(String value) {
        if (value.equals(RegistryEnum.zookeeper.toString())) {
            return RegistryEnum.zookeeper.getClazz();
        }
        return null;
    }
}