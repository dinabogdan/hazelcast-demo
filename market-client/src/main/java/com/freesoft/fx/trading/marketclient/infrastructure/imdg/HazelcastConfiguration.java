package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientConnectionStrategyConfig;
import com.hazelcast.core.HazelcastInstance;
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
        ClientConfig clientConfig = new ClientConfig();

        clientConfig.setManagedContext(springManagedContext);
        clientConfig.getConnectionStrategyConfig().setReconnectMode(ClientConnectionStrategyConfig.ReconnectMode.ON);
        clientConfig.getConnectionStrategyConfig().setAsyncStart(hazelcastProperties.isAsyncStartClient());

        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setInitialBackoffMillis(hazelcastProperties.getInitialBackoffMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMaxBackoffMillis(hazelcastProperties.getMaxBackoffMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMultiplier(hazelcastProperties.getMultiplier());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setClusterConnectTimeoutMillis(hazelcastProperties.getClusterConnectTimeoutMillis());
        clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setJitter(hazelcastProperties.getJitter());

        if (hazelcastProperties.isUserCodeDeploymentEnabled()) {
            enableUserCodeDeployment(clientConfig);
        }

        configureClientProperties(clientConfig, hazelcastProperties);

        return clientConfig;
    }

    @Bean
    public HazelcastExecutor hazelcastExecutor(HazelcastInstance hazelcastInstance, HazelcastProperties hazelcastProperties) {
        return new HazelcastExecutor(hazelcastInstance, hazelcastProperties);
    }


    private void enableUserCodeDeployment(ClientConfig clientConfig) {
        clientConfig.getUserCodeDeploymentConfig().setEnabled(true);

        //TODO: De adaugat task-urile
    }

    private void configureClientProperties(ClientConfig clientConfig, HazelcastProperties hazelcastProperties) {
        hazelcastProperties.getClientProperties().forEach(clientConfig::setProperty);
    }
}
