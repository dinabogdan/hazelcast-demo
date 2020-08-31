package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.util.function.Function;

public class PublishFailure<T> extends PublishResult<T> implements Serializable {

    private final RuntimeException exception;

    public PublishFailure(RuntimeException exception) {
        this.exception = exception;
    }

    @Override
    public <B> PublishResult<B> map(Function<T, B> f) {
        return new PublishFailure<>(exception);
    }

    @Override
    public <B> PublishResult<B> flatMap(Function<T, PublishResult<B>> f) {
        return new PublishFailure<>(exception);
    }

    @Override
    public String toString() {
        return "PublishFailure{" +
                "exception=" + exception +
                '}';
    }
}
