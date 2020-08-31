package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteLow implements Serializable {
    private final BigDecimal value;

    public QuoteLow(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QuoteLow{" +
                "value=" + value +
                '}';
    }
}
