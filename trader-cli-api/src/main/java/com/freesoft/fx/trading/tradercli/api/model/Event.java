package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;

public abstract class Event implements Serializable {

    private final DateTime occurredAt;

    protected Event(DateTime occurredAt) {
        this.occurredAt = occurredAt;
    }
}
