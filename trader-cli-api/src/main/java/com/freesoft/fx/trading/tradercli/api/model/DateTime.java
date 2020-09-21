package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DateTime implements Serializable {
    private final LocalDateTime value;

    public DateTime(LocalDateTime value) {
        this.value = value;
    }
}
