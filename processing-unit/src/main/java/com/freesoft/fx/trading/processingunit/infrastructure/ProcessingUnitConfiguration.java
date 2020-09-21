package com.freesoft.fx.trading.processingunit.infrastructure;

import com.freesoft.fx.trading.processingunit.domain.QuotesRepository;
import com.freesoft.fx.trading.processingunit.domain.TraderHistoryRepository;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessingUnitConfiguration {

    @Bean
    public QuotesRepository quotesRepository(HazelcastInstance hazelcastInstance) {
        return new QuotesRepositoryImpl(hazelcastInstance);
    }

    @Bean
    public TraderHistoryRepository traderHistoryRepository(HazelcastInstance hazelcastInstance) {
        return new TraderHistoryRepositoryImpl(hazelcastInstance);
    }
}
