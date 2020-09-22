package com.freesoft.fx.trading.tradercli.application.model;

import java.util.Objects;

public abstract class TradeCommand {

    private final TradeCommandPayload payload;

    protected TradeCommand(TradeCommandPayload payload) {
        this.payload = payload;
    }

    public TradeCommandPayload getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeCommand that = (TradeCommand) o;
        return Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }

    public static class BuyCommand extends TradeCommand {

        protected BuyCommand(TradeCommandPayload payload) {
            super(payload);
        }

        public static TradeCommand aBuyCommand(TradeCommandPayload payload) {
            return new BuyCommand(payload);
        }

        @Override
        public String toString() {
            return "BuyCommand{" +
                    "payload=" + super.payload +
                    '}';
        }
    }

    public static class SellCommand extends TradeCommand {

        protected SellCommand(TradeCommandPayload payload) {
            super(payload);
        }

        public static TradeCommand aSellCommand(TradeCommandPayload payload) {
            return new SellCommand(payload);
        }

        @Override
        public String toString() {
            return "SellCommand{" +
                    "payload=" + super.payload +
                    '}';
        }
    }
}
