package com.freesoft.fx.trading.tradercli.api.model;

public class BuySucceeded extends Event {

    public BuySucceeded(DateTime occurredAt) {
        super(occurredAt);
    }

    @Override
    public String toString() {
        return "BuySucceeded{" +
                "occurredAt=" + occurredAt +
                '}';
    }
}
