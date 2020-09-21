package com.freesoft.fx.trading.marketclient.infrastructure.pu;

import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.application.MarketChannelPublisher;
import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastExecutor;
import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastRequest;
import reactor.core.publisher.Mono;

import java.util.List;

public class MarketChannelPublisherImpl implements MarketChannelPublisher {
    private final HazelcastExecutor hazelcastExecutor;

    MarketChannelPublisherImpl(HazelcastExecutor hazelcastExecutor) {
        this.hazelcastExecutor = hazelcastExecutor;
    }

    @Override
    public Mono<PublishResult<List<Quote>>> publish(List<Quote> quotes) {
        return hazelcastExecutor.execute(HazelcastRequest.of(PublishQuotesTask.of(quotes)));
    }

    @Override
    public Mono<PublishResult<Quote>> publish(Quote quote) {
        return hazelcastExecutor.execute(HazelcastRequest.of(PublishQuoteTask.of(quote)));
    }
}
