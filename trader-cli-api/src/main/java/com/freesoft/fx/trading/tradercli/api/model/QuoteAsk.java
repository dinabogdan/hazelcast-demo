package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteAsk implements Serializable {
    private final BigDecimal value;

    public QuoteAsk(BigDecimal value) {
        this.value = value;
    }
}
