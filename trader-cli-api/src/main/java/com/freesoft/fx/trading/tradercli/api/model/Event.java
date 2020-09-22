package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Event implements Serializable {

    protected final DateTime occurredAt;

    protected Event(DateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    public DateTime getOccurredAt() {
        return occurredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(occurredAt, event.occurredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occurredAt);
    }
}
