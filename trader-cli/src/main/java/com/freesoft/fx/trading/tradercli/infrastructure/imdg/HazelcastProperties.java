package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

@ConstructorBinding
@ConfigurationProperties(prefix = "hazelcast")
public class HazelcastProperties {

    private int initialBackoffMMillis;
    private int maxBackoffMillis;
    private double multiplier;
    private long clusterConnectTimeoutMillis;
    private double jitter;
    private boolean asyncStartClient;
    private boolean userCodeDeploymentEnabled;
    private Map<String, String> clientProperties;
    private TcpProperties tcp;
    private String executorServiceName;

    public HazelcastProperties() {

    }

    public int getInitialBackoffMMillis() {
        return initialBackoffMMillis;
    }

    public void setInitialBackoffMMillis(int initialBackoffMMillis) {
        this.initialBackoffMMillis = initialBackoffMMillis;
    }

    public int getMaxBackoffMillis() {
        return maxBackoffMillis;
    }

    public void setMaxBackoffMillis(int maxBackoffMillis) {
        this.maxBackoffMillis = maxBackoffMillis;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public long getClusterConnectTimeoutMillis() {
        return clusterConnectTimeoutMillis;
    }

    public void setClusterConnectTimeoutMillis(long clusterConnectTimeoutMillis) {
        this.clusterConnectTimeoutMillis = clusterConnectTimeoutMillis;
    }

    public double getJitter() {
        return jitter;
    }

    public void setJitter(double jitter) {
        this.jitter = jitter;
    }

    public boolean isAsyncStartClient() {
        return asyncStartClient;
    }

    public void setAsyncStartClient(boolean asyncStartClient) {
        this.asyncStartClient = asyncStartClient;
    }

    public boolean isUserCodeDeploymentEnabled() {
        return userCodeDeploymentEnabled;
    }

    public void setUserCodeDeploymentEnabled(boolean userCodeDeploymentEnabled) {
        this.userCodeDeploymentEnabled = userCodeDeploymentEnabled;
    }

    public Map<String, String> getClientProperties() {
        return clientProperties;
    }

    public void setClientProperties(Map<String, String> clientProperties) {
        this.clientProperties = clientProperties;
    }

    public TcpProperties getTcp() {
        return tcp;
    }

    public void setTcp(TcpProperties tcp) {
        this.tcp = tcp;
    }

    public String getExecutorServiceName() {
        return executorServiceName;
    }

    public void setExecutorServiceName(String executorServiceName) {
        this.executorServiceName = executorServiceName;
    }
}
