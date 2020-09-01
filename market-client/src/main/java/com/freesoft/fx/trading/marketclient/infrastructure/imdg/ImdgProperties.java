package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "hazelcast")
public record ImdgProperties(
        int initialBackoffMillis,
        int maxBackoffMillis,
        double multiplier,
        long clusterConnectTimeoutMillis,
        double jitter,
        boolean asyncStartClient,
        boolean userCodeDeploymentEnabled,
        Map<String, String> clientProperties,
        TcpProperties tcp,
        String executorServiceName
) {
}
