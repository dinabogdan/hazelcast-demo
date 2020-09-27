package com.freesoft.fx.trading.processingunit.infrastructure.imdg;

import com.hazelcast.config.*;
import com.hazelcast.spring.context.SpringManagedContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public SpringManagedContext springManagedContext() {
        return new SpringManagedContext();
    }

    @Bean
    public Config hazelcastConfig(SpringManagedContext springManagedContext, HazelcastConfigurationProperties hazelcastConfigurationProperties) {
        var config = new com.hazelcast.config.Config();

        config.setManagedContext(springManagedContext);
        config.getUserCodeDeploymentConfig().setEnabled(true);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);

        if (hazelcastConfigurationProperties.getTcp().getEnabled()) {
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setMembers(hazelcastConfigurationProperties.getTcp().getMembers());
        }

        configureTraderHistoryMap(config, hazelcastConfigurationProperties);
        configureQuotesMap(config);

        return config;
    }

    private void configureTraderHistoryMap(Config config, HazelcastConfigurationProperties properties) {
        var traderHistoryMapConfig = new MapConfig();
        traderHistoryMapConfig.setName("TRADER_HISTORY_MAP");
        traderHistoryMapConfig.setBackupCount(2);
        traderHistoryMapConfig.setTimeToLiveSeconds(3600);
        traderHistoryMapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.NONE);
        traderHistoryMapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.PER_NODE);
        traderHistoryMapConfig.getEvictionConfig().setSize(properties.getMaxSize());
        config.addMapConfig(traderHistoryMapConfig);
    }

    private void configureQuotesMap(Config config) {
        var quotesMapConfig = config.getReplicatedMapConfig("QUOTES_MAP");
        quotesMapConfig.setInMemoryFormat(InMemoryFormat.BINARY);
    }
}
