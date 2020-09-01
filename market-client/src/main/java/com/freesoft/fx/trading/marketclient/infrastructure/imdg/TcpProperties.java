package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "hazelcast.tcp")
public record TcpProperties(
        boolean enabled,
        List<String> members
) {

}
