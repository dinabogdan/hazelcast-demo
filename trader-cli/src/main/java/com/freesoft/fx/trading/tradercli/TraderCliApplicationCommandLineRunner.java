package com.freesoft.fx.trading.tradercli;

import com.freesoft.fx.trading.tradercli.api.model.Quote;
import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.QuotesMapEntryListener;
import com.hazelcast.replicatedmap.ReplicatedMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class TraderCliApplicationCommandLineRunner implements CommandLineRunner {

    private final ReplicatedMap<QuotePair, Quote> quotesMap;
    private final QuotesMapEntryListener quotesMapEntryListener;

    TraderCliApplicationCommandLineRunner(ReplicatedMap<QuotePair, Quote> quotesMap, QuotesMapEntryListener quotesMapEntryListener) {
        this.quotesMap = quotesMap;
        this.quotesMapEntryListener = quotesMapEntryListener;
    }

    @Override
    public void run(String... args) throws Exception {
        quotesMap.addEntryListener(quotesMapEntryListener);
    }
}
