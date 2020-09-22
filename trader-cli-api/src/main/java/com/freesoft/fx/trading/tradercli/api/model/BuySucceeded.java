package com.freesoft.fx.trading.tradercli.api.model;

public class BuySucceeded extends Event {

    protected BuySucceeded(DateTime occurredAt) {
        super(occurredAt);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "BuySucceeded{" +
                "occurredAt=" + occurredAt +
                '}';
    }
}
