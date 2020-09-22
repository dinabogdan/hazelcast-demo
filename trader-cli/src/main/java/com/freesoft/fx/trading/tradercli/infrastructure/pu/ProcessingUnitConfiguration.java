package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import com.freesoft.fx.trading.tradercli.application.TradingChannel;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.HazelcastExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessingUnitConfiguration {

    @Bean
    public TradingChannel tradingChannel(HazelcastExecutor hazelcastExecutor) {
        return new TradingChannelImpl(hazelcastExecutor);
    }
}
