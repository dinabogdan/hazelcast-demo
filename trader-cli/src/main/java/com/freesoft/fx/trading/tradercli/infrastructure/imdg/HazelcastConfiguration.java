package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import com.freesoft.fx.trading.tradercli.TraderCliApplication;
import com.freesoft.fx.trading.tradercli.api.model.Quote;
import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.infrastructure.pu.BuyTask;
import com.freesoft.fx.trading.tradercli.infrastructure.pu.SellTask;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientConnectionStrategyConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.replicatedmap.ReplicatedMap;
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
    public ClientConfig clientConfig(SpringManagedContext springManagedContext, HazelcastProperties hazelcastProperties) {
        var clientConfig = new ClientConfig();

        clientConfig.setManagedContext(springManagedContext);
        clientConfig.getConnectionStrategyConfig().setReconnectMode(ClientConnectionStrategyConfig.ReconnectMode.ON);
        clientConfig.getConnectionStrategyConfig().setAsyncStart(hazelcastProperties.isAsyncStartClient());

        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setInitialBackoffMillis(hazelcastProperties.getInitialBackoffMMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMaxBackoffMillis(hazelcastProperties.getMaxBackoffMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMultiplier(hazelcastProperties.getMultiplier());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setClusterConnectTimeoutMillis(hazelcastProperties.getClusterConnectTimeoutMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setJitter(hazelcastProperties.getJitter());

        if (hazelcastProperties.isUserCodeDeploymentEnabled()) {
            configureUserCodeDeployment(clientConfig);
        }

        configureClientProperties(clientConfig, hazelcastProperties);

        return clientConfig;
    }

    @Bean
    public HazelcastExecutor hazelcastExecutor(HazelcastInstance hazelcastInstance, HazelcastProperties hazelcastProperties) {
        return new HazelcastExecutor(hazelcastInstance, hazelcastProperties);
    }

    @Bean
    public QuotesMapEntryListener quotesMapEntryListener() {
        return new QuotesMapEntryListener();
    }

    @Bean
    public ReplicatedMap<QuotePair, Quote> replicatedMap(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getReplicatedMap("QUOTES_MAP");
    }

    private void configureUserCodeDeployment(ClientConfig config) {
        config.getUserCodeDeploymentConfig().setEnabled(true);

        config.getUserCodeDeploymentConfig().addClass(BuyTask.class);
        config.getUserCodeDeploymentConfig().addClass(SellTask.class);

        config.setClassLoader(TraderCliApplication.class.getClassLoader());
    }

    private void configureClientProperties(ClientConfig clientConfig, HazelcastProperties hazelcastProperties) {
        hazelcastProperties.getClientProperties().forEach(clientConfig::setProperty);
    }
}
