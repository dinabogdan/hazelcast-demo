package com.freesoft.fx.trading.processingunit.infrastructure;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;

@Component
public class TraderHistoryRepositoryImpl {

    private final HazelcastInstance hazelcastInstance;

    TraderHistoryRepositoryImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

}
