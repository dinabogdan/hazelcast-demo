package com.freesoft.fx.trading.tradercli.api.model;

public class BuyCommand extends Command {

    public BuyCommand(TraderRefId traderRefId, int units, QuotePair quotePair) {
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
}
