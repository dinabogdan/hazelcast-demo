package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteLow implements Serializable {

    private final BigDecimal value;

    public QuoteLow(BigDecimal value) {
        this.value = value;
    }
}
