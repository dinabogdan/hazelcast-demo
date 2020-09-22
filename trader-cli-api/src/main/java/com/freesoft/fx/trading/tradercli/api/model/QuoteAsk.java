package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class QuoteAsk implements Serializable {
    private final BigDecimal value;

    public QuoteAsk(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QuoteAsk{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteAsk quoteAsk = (QuoteAsk) o;
        return Objects.equals(value, quoteAsk.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
