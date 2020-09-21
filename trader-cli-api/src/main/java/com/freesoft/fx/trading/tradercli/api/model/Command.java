package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;

public abstract class Command implements Serializable {

    private final TraderRefId traderRefId;
    private final int units;
    private final QuotePair quotePair;

    protected Command(TraderRefId traderRefId, int units, QuotePair quotePair) {
        this.traderRefId = traderRefId;
        this.units = units;
        this.quotePair = quotePair;
    }
}
