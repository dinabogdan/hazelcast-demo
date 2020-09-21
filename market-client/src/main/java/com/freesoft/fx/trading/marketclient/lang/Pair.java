package com.freesoft.fx.trading.marketclient.lang;

import java.io.Serializable;

public class Pair<T1, T2> implements Serializable {

    private final T1 first;
    private final T2 second;

    private Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public static <R1, R2> Pair<R1, R2> of(R1 first, R2 second) {
        return new Pair<>(first, second);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
