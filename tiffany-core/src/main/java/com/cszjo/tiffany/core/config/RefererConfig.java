package com.cszjo.tiffany.core.config;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by hansiming on 2017/10/26.
 */
public class RefererConfig<T> extends AbstractConfig {

    private Class<T> interfaceClazz;
    private Map<String, Method> methods;

    public Class<T> getInterfaceClazz() {
        return interfaceClazz;
    }

    public void setInterfaceClazz(Class<T> interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
    }

    public Map<String, Method> getMethods() {
        return methods;
    }

    public void setMethods(Map<String, Method> methods) {
        this.methods = methods;
    }
}
