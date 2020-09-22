package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Time implements Serializable {

    private final LocalTime value;

    public Time(LocalTime value) {
        this.value = value;
    }

    public LocalTime getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(value, time.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
