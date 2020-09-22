package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class QuoteChange implements Serializable {
    private final BigDecimal value;

    public QuoteChange(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteChange that = (QuoteChange) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "QuoteChange{" +
                "value=" + value +
                '}';
    }
}
