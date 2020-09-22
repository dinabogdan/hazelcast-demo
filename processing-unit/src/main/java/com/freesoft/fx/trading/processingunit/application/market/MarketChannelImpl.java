package com.freesoft.fx.trading.processingunit.application.market;

import com.freesoft.fx.trading.marketclient.api.model.PublishFailure;
import com.freesoft.fx.trading.marketclient.api.model.PublishResult;
import com.freesoft.fx.trading.marketclient.api.model.PublishSuccess;
import com.freesoft.fx.trading.marketclient.api.model.Quote;
import com.freesoft.fx.trading.marketclient.api.service.MarketChannel;
import com.freesoft.fx.trading.processingunit.domain.QuotesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarketChannelImpl implements MarketChannel {
    private static final Logger logger = LoggerFactory.getLogger(MarketChannelImpl.class);

    private final QuotesRepository quotesRepository;

    MarketChannelImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public PublishResult<List<Quote>> publish(List<Quote> quotes) {
        try {
            quotesRepository.addAll(quotes);
            var result = new PublishSuccess<>(quotes);
            logger.info("Published " + quotes);
            return result;
        } catch (Exception ex) {
            return new PublishFailure<>(new RuntimeException(ex));
        }
    }

    @Override
    public PublishResult<Quote> publish(Quote quote) {
        try {
            quotesRepository.add(quote);
            var result = new PublishSuccess<>(quote);
            logger.info("Published " + quote);
            return result;
        } catch (Exception ex) {
            return new PublishFailure<>(new RuntimeException(ex));
        }
    }
}
