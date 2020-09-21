package com.freesoft.fx.trading.marketclient.application;

import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.Quote;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MarketChannelPublisher {

    Mono<PublishResult<List<Quote>>> publish(List<Quote> quotes);

    Mono<PublishResult<Quote>> publish(Quote quote);
}
