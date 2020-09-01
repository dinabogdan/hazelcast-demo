package com.freesoft.fx.trading.marketclient;

import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastExecutor;
import com.freesoft.fx.trading.marketclient.infrastructure.imdg.ImdgProperties;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientConnectionStrategyConfig;
import com.hazelcast.spring.context.SpringManagedContext;
import org.springframework.fu.jafu.BeanDefinitionDsl;
import org.springframework.fu.jafu.JafuApplication;

import java.util.function.Supplier;

import static org.springframework.fu.jafu.Jafu.reactiveWebApplication;

public class MarketClientApplication {

    public static JafuApplication marketClientApp = reactiveWebApplication(applicationDsl ->
            applicationDsl.beans(beanDefinitionDsl -> beanDefinitionDsl
                    .bean(SpringManagedContext.class)
                    .bean(ClientConfig.class, supplyClientConfigBean(beanDefinitionDsl))
                    .bean(HazelcastExecutor.class)
            )
    );

    private static Supplier<ClientConfig> supplyClientConfigBean(BeanDefinitionDsl beanDefinitionDsl) {
        return () -> {
            var clientConfig = new ClientConfig();
            var springManagedContext = beanDefinitionDsl.ref(SpringManagedContext.class);
            var imdgProperties = beanDefinitionDsl.ref(ImdgProperties.class);

            clientConfig.setManagedContext(springManagedContext);
            clientConfig.getConnectionStrategyConfig().setReconnectMode(ClientConnectionStrategyConfig.ReconnectMode.ON);
            clientConfig.getConnectionStrategyConfig().setAsyncStart(imdgProperties.asyncStartClient());

            clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setInitialBackoffMillis(imdgProperties.initialBackoffMillis());
            clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMaxBackoffMillis(imdgProperties.maxBackoffMillis());
            clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setMultiplier(imdgProperties.multiplier());
            clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setClusterConnectTimeoutMillis(imdgProperties.clusterConnectTimeoutMillis());
            clientConfig.getConnectionStrategyConfig().getConnectionRetryConfig().setJitter(imdgProperties.jitter());

            if (imdgProperties.userCodeDeploymentEnabled()) {
                clientConfig.getUserCodeDeploymentConfig().setEnabled(true);

                clientConfig.setClassLoader(MarketClientApplication.class.getClassLoader());
            }

            return clientConfig;
        };
    }

    public static void main(String[] args) {
        marketClientApp.run(args);
    }

}
