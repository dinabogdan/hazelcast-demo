package com.freesoft.fx.trading.marketclient.api.service;

import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.Quote;

import java.util.List;

public interface MarketChannel {

    PublishResult<List<Quote>> publish(List<Quote> quotes);

    PublishResult<Quote> publish(Quote quote);
}
