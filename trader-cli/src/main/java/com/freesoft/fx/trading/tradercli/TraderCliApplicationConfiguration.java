package com.freesoft.fx.trading.tradercli;

import com.freesoft.fx.trading.tradercli.api.model.Quote;
import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.QuotesMapEntryListener;
import com.hazelcast.replicatedmap.ReplicatedMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class TraderCliApplicationConfiguration {

    @Bean
    public TraderId traderId() {
        return TraderId.of(UUID.randomUUID().toString());
    }

    @Bean
    public TraderCliApplicationCommandLineRunner traderCliApplicationCommandLineRunner(
            QuotesMapEntryListener quotesMapEntryListener, ReplicatedMap<QuotePair, Quote> replicatedMap) {
        return new TraderCliApplicationCommandLineRunner(replicatedMap, quotesMapEntryListener);
    }

}
