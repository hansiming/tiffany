package com.cszjo.tiffany.core.config;

import com.cszjo.tiffany.core.loadbalance.LoadBalanceEnum;

/**
 * Created by hansiming on 2018/3/7.
 */
public class ProtocolConfig extends AbstractConfig {

    private String name;
    private LoadBalanceEnum loadBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoadBalanceEnum getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(LoadBalanceEnum loadBalance) {
        this.loadBalance = loadBalance;
    }
}
