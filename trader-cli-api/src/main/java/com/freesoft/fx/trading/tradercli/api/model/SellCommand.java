package com.freesoft.fx.trading.tradercli.api.model;

public class SellCommand extends Command {

    protected SellCommand(TraderRefId traderRefId, int units, QuotePair quotePair) {
        super(traderRefId, units, quotePair);
    }

    @Override
    public String toString() {
        return "SellCommand{" +
                "traderRefId=" + traderRefId +
                ", units=" + units +
                ", quotePair=" + quotePair +
                '}';
    }
}
