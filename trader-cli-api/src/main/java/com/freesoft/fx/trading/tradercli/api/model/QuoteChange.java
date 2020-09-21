package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteChange implements Serializable {
    private final BigDecimal value;

    public QuoteChange(BigDecimal value) {
        this.value = value;
    }
}
