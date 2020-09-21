package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;

public record Quote(
        QuotePair pair,
        QuoteBid bid,
        QuoteAsk ask,
        QuoteHigh high,
        QuoteLow low,
        QuoteChange change,
        Time time
) implements Serializable {
}
