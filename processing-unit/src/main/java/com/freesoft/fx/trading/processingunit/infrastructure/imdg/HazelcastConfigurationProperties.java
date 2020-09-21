package com.freesoft.fx.trading.processingunit.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "hazelcast")
public class HazelcastConfigurationProperties {

    private Boolean monitoring;
    private int maxSize;
    private TcpProperties tcp;

    public HazelcastConfigurationProperties(Boolean monitoring, int maxSize, TcpProperties tcp) {
        this.monitoring = monitoring;
        this.maxSize = maxSize;
        this.tcp = tcp;
    }

    public Boolean getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Boolean monitoring) {
        this.monitoring = monitoring;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public TcpProperties getTcp() {
        return tcp;
    }

    public void setTcp(TcpProperties tcp) {
        this.tcp = tcp;
    }
}
