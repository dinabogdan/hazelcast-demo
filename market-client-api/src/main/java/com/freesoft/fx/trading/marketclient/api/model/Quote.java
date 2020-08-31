package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;

public record Quote(
        QuotePair pair,
        QuoteBid bid,
        QuoteAsk ask,
        QuoteHigh high,
        QuoteLow low,
        QuoteTime time) implements Serializable {
}
