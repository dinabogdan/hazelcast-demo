package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.util.Objects;

public class TraderRefId implements Serializable {
    private final String value;

    public TraderRefId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TraderRefId{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraderRefId that = (TraderRefId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
