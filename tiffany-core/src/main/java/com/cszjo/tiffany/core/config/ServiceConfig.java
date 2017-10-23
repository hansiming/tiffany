package com.cszjo.tiffany.core.config;

/**
 * Created by hansiming on 2017/10/23.
 */
public class ServiceConfig<T> extends AbstractConfig {

    private Class<T> interfaceClazz;
    private T ref;

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

    @Override
    public String toString() {
        return "ServiceConfig{" +
                "interfaceClazz='" + interfaceClazz + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
