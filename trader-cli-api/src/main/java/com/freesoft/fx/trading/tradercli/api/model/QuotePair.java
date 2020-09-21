package com.freesoft.fx.trading.tradercli.api.model;

public enum QuotePair {
    EUR_USD("EUR/USD"),
    GBP_USD("GBP/USD"),
    USD_JPY("USD/JPY"),
    USD_CHF("USD/CHF"),
    AUD_USD("AUD/USD"),
    USD_CAD("USD/CAD");

    public final String symbol;

    QuotePair(String symbol) {
        this.symbol = symbol;
    }
}
