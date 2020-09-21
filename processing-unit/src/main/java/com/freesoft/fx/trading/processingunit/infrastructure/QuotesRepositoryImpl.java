package com.freesoft.fx.trading.processingunit.infrastructure;

import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.processingunit.domain.QuotesRepository;
import com.hazelcast.core.HazelcastInstance;

import java.util.List;

public class QuotesRepositoryImpl implements QuotesRepository {

    private final HazelcastInstance hazelcastInstance;

    QuotesRepositoryImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public List<Quote> findAll() {
        return null;
    }

    @Override
    public void addAll(List<Quote> quotes) {

    }

    @Override
    public void add(Quote quote) {

    }
}
