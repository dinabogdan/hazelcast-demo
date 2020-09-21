package com.freesoft.fx.trading.processingunit.infrastructure;

import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.api.model.QuotePair;
import com.freesoft.fx.trading.processingunit.domain.QuotesRepository;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.replicatedmap.ReplicatedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuotesRepositoryImpl implements QuotesRepository {

    private static final Logger log = LoggerFactory.getLogger(QuotesRepositoryImpl.class);

    private final HazelcastInstance hazelcastInstance;

    QuotesRepositoryImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public List<Quote> findAll() {
        return new ArrayList<>(getMap().values());
    }

    @Override
    public void addAll(List<Quote> quotes) {
        getMap().putAll(quotes.stream().collect(Collectors.toMap(Quote::pair, Function.identity())));
        log.info("Added " + quotes);
    }

    @Override
    public void add(Quote quote) {
        getMap().put(quote.pair(), quote);
        log.info("Added " + quote);
    }

    private ReplicatedMap<QuotePair, Quote> getMap() {
        return hazelcastInstance.getReplicatedMap("QUOTES_MAP");
    }
}
