package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class DateTime implements Serializable {
    private final LocalDateTime value;

    public DateTime(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return Objects.equals(value, dateTime.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
