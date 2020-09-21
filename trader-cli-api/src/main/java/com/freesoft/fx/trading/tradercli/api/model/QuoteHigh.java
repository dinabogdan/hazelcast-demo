package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteHigh implements Serializable {
    private final BigDecimal value;

    public QuoteHigh(BigDecimal value) {
        this.value = value;
    }
}
