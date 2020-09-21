package com.freesoft.fx.trading.marketclient;

import com.freesoft.fx.trading.marketclient.api.model.*;
import com.freesoft.fx.trading.marketclient.application.MarketChannelPublisher;
import com.freesoft.fx.trading.marketclient.lang.BigDecimalRandomizer;
import com.freesoft.fx.trading.marketclient.lang.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
public class MarketClientCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MarketClientCommandLineRunner.class);

    private final MarketChannelPublisher marketChannelPublisher;

    public MarketClientCommandLineRunner(MarketChannelPublisher marketChannelPublisher) {
        this.marketChannelPublisher = marketChannelPublisher;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting to publish market changes...");
        Flux.interval(Duration.of(1500, ChronoUnit.MILLIS))
                .doOnNext(tick -> {
                    log.info("Tick " + tick + " ...");
                    Flux.fromArray(QuotePair.values())
                            .delayElements(Duration.of(250, ChronoUnit.MILLIS))
                            .doOnNext(quotePair -> marketChannelPublisher.publish(newQuote(quotePair)).subscribe())
                            .subscribe();
                })
                .subscribe();
    }

    private static Quote newQuote(QuotePair quotePair) {
        var time = new QuoteTime(LocalTime.now());
        var bid = randomBid(quotePair);
        var ask = randomAsk(quotePair, bid);
        var margins = randomMargins(quotePair);
        return new Quote(quotePair, bid, ask, margins.getSecond(), margins.getFirst(), time);
    }

    private static Pair<QuoteLow, QuoteHigh> randomMargins(QuotePair quotePair) {
        return switch (quotePair) {
            case AUD_USD -> Pair.of(new QuoteLow(BigDecimal.valueOf(0.6830)), new QuoteHigh(BigDecimal.valueOf(0.6950)));
            case EUR_USD -> Pair.of(new QuoteLow(BigDecimal.valueOf(1.1168)), new QuoteHigh(BigDecimal.valueOf(1.1260)));
            case GBP_USD -> Pair.of(new QuoteLow(BigDecimal.valueOf(1.2344)), new QuoteHigh(BigDecimal.valueOf(1.2460)));
            case USD_CAD -> Pair.of(new QuoteLow(BigDecimal.valueOf(1.3545)), new QuoteHigh(BigDecimal.valueOf(1.3600)));
            case USD_CHF -> Pair.of(new QuoteLow(BigDecimal.valueOf(0.9488)), new QuoteHigh(BigDecimal.valueOf(0.9560)));
            case USD_JPY -> Pair.of(new QuoteLow(BigDecimal.valueOf(106.77)), new QuoteHigh(BigDecimal.valueOf(107.70)));
        };
    }

    private static QuoteBid randomBid(QuotePair quotePair) {
        return switch (quotePair) {
            case AUD_USD -> new QuoteBid(BigDecimalRandomizer.random("0.7"));
            case EUR_USD -> new QuoteBid(BigDecimalRandomizer.random("1.1200"));
            case GBP_USD -> new QuoteBid(BigDecimalRandomizer.random("1.2500"));
            case USD_CAD -> new QuoteBid(BigDecimalRandomizer.random("1.4"));
            case USD_CHF -> new QuoteBid(BigDecimalRandomizer.random("1.0"));
            case USD_JPY -> new QuoteBid(BigDecimalRandomizer.random("110.0"));
        };
    }

    private static QuoteAsk randomAsk(QuotePair pair, QuoteBid bid) {
        return switch (pair) {
            case AUD_USD -> new QuoteAsk(bid.getValue().plus().add(BigDecimalRandomizer.random("0.0005")));
            case USD_JPY, USD_CHF -> new QuoteAsk(bid.getValue().plus().add(BigDecimalRandomizer.random("0.3")));
            case USD_CAD -> new QuoteAsk(bid.getValue().plus().add(BigDecimalRandomizer.random("0.001")));
            case GBP_USD -> new QuoteAsk(bid.getValue().plus().add(BigDecimalRandomizer.random("0.01")));
            case EUR_USD -> new QuoteAsk(bid.getValue().plus().add(BigDecimalRandomizer.random("0.0003")));
        };
    }
}
