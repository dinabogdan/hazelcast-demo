package com.freesoft.fx.trading.tradercli.api.model;

public class BuyCommand extends Command {

    protected BuyCommand(TraderRefId traderRefId, int units, QuotePair quotePair) {
        super(traderRefId, units, quotePair);
    }
}
