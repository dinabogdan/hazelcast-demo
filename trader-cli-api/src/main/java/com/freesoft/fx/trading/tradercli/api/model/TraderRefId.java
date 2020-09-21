package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;

public class TraderRefId implements Serializable {
    private final String value;

    public TraderRefId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
