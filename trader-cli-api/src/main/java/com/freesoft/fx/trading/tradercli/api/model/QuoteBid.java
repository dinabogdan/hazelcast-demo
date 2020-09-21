package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteBid implements Serializable {
    private final BigDecimal value;

    public QuoteBid(BigDecimal value) {
        this.value = value;
    }
}
