package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Command implements Serializable {

    protected final TraderRefId traderRefId;
    protected final int units;
    protected final QuotePair quotePair;

    protected Command(TraderRefId traderRefId, int units, QuotePair quotePair) {
        this.traderRefId = traderRefId;
        this.units = units;
        this.quotePair = quotePair;
    }

    public TraderRefId getTraderRefId() {
        return traderRefId;
    }

    public int getUnits() {
        return units;
    }

    public QuotePair getQuotePair() {
        return quotePair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return units == command.units &&
                Objects.equals(traderRefId, command.traderRefId) &&
                quotePair == command.quotePair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(traderRefId, units, quotePair);
    }
}
