package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteBid implements Serializable {

    private final BigDecimal value;


    public QuoteBid(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QuoteBid{" +
                "value=" + value +
                '}';
    }
}
