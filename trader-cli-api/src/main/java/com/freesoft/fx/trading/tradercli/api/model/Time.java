package com.freesoft.fx.trading.tradercli.api.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Time implements Serializable {

    private final LocalTime value;

    public Time(LocalTime value) {
        this.value = value;
    }
}
