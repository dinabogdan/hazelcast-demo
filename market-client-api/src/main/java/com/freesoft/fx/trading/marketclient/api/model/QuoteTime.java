package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.time.LocalTime;

public class QuoteTime implements Serializable {

    private final LocalTime value;

    QuoteTime(LocalTime value) {
        this.value = value;
    }

    public LocalTime getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QuoteTime{" +
                "value=" + value +
                '}';
    }
}
