package com.freesoft.fx.trading.marketclient.infrastructure.pu;

import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.api.service.MarketChannel;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

@SpringAware
public class PublishQuotesTask implements Callable<PublishResult<List<Quote>>>, Serializable {
    private static final long serialVersionUID = -321357656719161714L;

    private List<Quote> quotes;

    PublishQuotesTask(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @Autowired
    private transient MarketChannel marketChannel;

    @Override
    public PublishResult<List<Quote>> call() throws Exception {
        return marketChannel.publish(quotes);
    }

    public static Callable<PublishResult<List<Quote>>> of(List<Quote> quotes) {
        return new PublishQuotesTask(quotes);
    }
}
