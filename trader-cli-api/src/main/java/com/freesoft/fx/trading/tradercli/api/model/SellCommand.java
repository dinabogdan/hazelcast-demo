package com.freesoft.fx.trading.tradercli.api.model;

public class SellCommand extends Command {

    protected SellCommand(TraderRefId traderRefId, int units, QuotePair quotePair) {
        super(traderRefId, units, quotePair);
    }
}
