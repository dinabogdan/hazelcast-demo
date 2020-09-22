package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class QuoteLow implements Serializable {

    private final BigDecimal value;

    public QuoteLow(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteLow quoteLow = (QuoteLow) o;
        return Objects.equals(value, quoteLow.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "QuoteLow{" +
                "value=" + value +
                '}';
    }
}
