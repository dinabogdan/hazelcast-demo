package com.freesoft.fx.trading.tradercli.api.model;

public class BuyCommand extends Command {

    protected BuyCommand(TraderRefId traderRefId, int units, QuotePair quotePair) {
        super(traderRefId, units, quotePair);
    }

    @Override
    public String toString() {
        return "BuyCommand{" +
                "traderRefId=" + traderRefId +
                ", units=" + units +
                ", quotePair=" + quotePair +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
