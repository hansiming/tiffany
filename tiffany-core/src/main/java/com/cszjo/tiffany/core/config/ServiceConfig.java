package com.cszjo.tiffany.core.config;

import org.springframework.context.ApplicationContext;

/**
 * Created by hansiming on 2017/10/23.
 */
public class ServiceConfig<T> extends AbstractConfig {

    private Class<T>           interfaceClazz;
    private T                  ref;
    private ApplicationContext context;
    private String             serverId;

    public Class<T> getInterfaceClazz() {
        return interfaceClazz;
    }

    public void setInterfaceClazz(Class<T> interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
    }

    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    private void start() {
        ServerBeanConfig server  = (ServerBeanConfig) context.getBean(serverId);
        server.getServices().add((ServiceConfig) context.getBean(this.id));
    }

    @Override
    public String toString() {
        return "ServiceConfig{" +
                "interfaceClazz='" + interfaceClazz + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
