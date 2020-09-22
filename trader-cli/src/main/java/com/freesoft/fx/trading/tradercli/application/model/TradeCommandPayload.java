package com.freesoft.fx.trading.tradercli.application.model;

import java.util.Objects;

public class TradeCommandPayload {

    private int units;
    private QuoteItem quoteItem;

    private TradeCommandPayload() {

    }

    private TradeCommandPayload(int units, QuoteItem quoteItem) {
        this.units = units;
        this.quoteItem = quoteItem;
    }

    public int getUnits() {
        return units;
    }

    public QuoteItem getQuoteItem() {
        return quoteItem;
    }

    private void setUnits(int units) {
        this.units = units;
    }

    private void setQuoteItem(QuoteItem quoteItem) {
        this.quoteItem = quoteItem;
    }

    @Override
    public String toString() {
        return "TradeCommandPayload{" +
                "units=" + units +
                ", quoteItem=" + quoteItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeCommandPayload that = (TradeCommandPayload) o;
        return units == that.units &&
                Objects.equals(quoteItem, that.quoteItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(units, quoteItem);
    }

    public static class TradeCommandPayloadBuilder {
        private final TradeCommandPayload payload;

        public TradeCommandPayloadBuilder(TradeCommandPayload payload) {
            this.payload = payload;
        }

        public static TradeCommandPayloadBuilder newInstance() {
            return new TradeCommandPayloadBuilder(new TradeCommandPayload());
        }

        public TradeCommandPayloadBuilder withUnits(int units) {
            this.payload.setUnits(units);
            return this;
        }

        public TradeCommandPayloadBuilder withQuoteItem(QuoteItem quoteItem) {
            this.payload.setQuoteItem(quoteItem);
            return this;
        }

        public TradeCommandPayload build() {
            return this.payload;
        }
    }
}
