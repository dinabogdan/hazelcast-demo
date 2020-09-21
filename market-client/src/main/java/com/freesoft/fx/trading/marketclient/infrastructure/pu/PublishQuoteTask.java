package com.freesoft.fx.trading.marketclient.infrastructure.pu;

import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.api.service.MarketChannel;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.Callable;

@SpringAware
public class PublishQuoteTask implements Callable<PublishResult<Quote>>, Serializable {
    private static final long serialVersionUID = -321357656719164314L;

    private Quote quote;

    @Autowired
    private transient MarketChannel marketChannel;

    PublishQuoteTask(Quote quote) {
        this.quote = quote;
    }

    @Override
    public PublishResult<Quote> call() throws Exception {
        return marketChannel.publish(quote);
    }

    public static Callable<PublishResult<Quote>> of(Quote quote) {
        return new PublishQuoteTask(quote);
    }
}
