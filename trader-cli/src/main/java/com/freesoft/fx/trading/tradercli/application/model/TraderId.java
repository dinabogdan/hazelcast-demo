package com.freesoft.fx.trading.tradercli.application.model;

public class TraderId {

    private final String value;

    TraderId(String value) {
        this.value = value;
    }

    public static TraderId of(String value) {
        return new TraderId(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TraderId{" +
                "value='" + value + '\'' +
                '}';
    }
}
