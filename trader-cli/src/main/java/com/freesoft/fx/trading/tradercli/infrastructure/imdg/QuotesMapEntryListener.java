package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import java.io.Serializable;

import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.api.model.QuotePair;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.map.MapEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuotesMapEntryListener implements EntryListener<QuotePair, Quote>, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(QuotesMapEntryListener.class);

    @Override
    public void entryAdded(EntryEvent<QuotePair, Quote> event) {
        logger.info("A new entry " + event.getValue() + " was added");
    }

    @Override
    public void entryEvicted(EntryEvent<QuotePair, Quote> event) {
        throw new IllegalStateException("Entries can not be evicted");
    }

    @Override
    public void entryExpired(EntryEvent<QuotePair, Quote> event) {
        throw new IllegalStateException("Entries can not be expired");
    }

    @Override
    public void entryRemoved(EntryEvent<QuotePair, Quote> event) {
        throw new IllegalStateException("Entries can not be removed");
    }

    @Override
    public void entryUpdated(EntryEvent<QuotePair, Quote> event) {
        logger.info("An entry for " + event.getKey() + " was updated with " + event.getValue());
    }

    @Override
    public void mapCleared(MapEvent event) {
        throw new IllegalStateException("Map can not be cleared");
    }

    @Override
    public void mapEvicted(MapEvent event) {
        throw new IllegalStateException("Map can not be evicted");
    }
}
