package com.freesoft.fx.trading.tradercli.api.model;

public class SellSucceeded extends Event {

    public SellSucceeded(DateTime occurredAt) {
        super(occurredAt);
    }

    @Override
    public String toString() {
        return "SellSucceeded{" +
                "occurredAt=" + occurredAt +
                '}';
    }
}
