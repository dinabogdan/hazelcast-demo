package com.freesoft.fx.trading.marketclient.infrastructure.pu;

import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessingUnitConfiguration {

    @Bean
    public MarketChannelPublisherImpl marketChannelPublisher(HazelcastExecutor hazelcastExecutor) {
        return new MarketChannelPublisherImpl(hazelcastExecutor);
    }
}
