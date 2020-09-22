package com.freesoft.fx.trading.tradercli.application.model;

public enum QuoteItem {
    EUR_USD("EUR/USD"),
    GBP_USD("GBP/USD"),
    USD_JPY("USD/JPY"),
    USD_CHF("USD/CHF"),
    AUD_USD("AUD/USD"),
    USD_CAD("USD/CAD");

    private final String symbol;

    QuoteItem(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
