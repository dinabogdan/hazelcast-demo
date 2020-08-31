package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.util.function.Function;

public class PublishSuccess<T> extends PublishResult<T> implements Serializable {

    private final T value;

    public PublishSuccess(T value) {
        this.value = value;
    }

    @Override
    public <B> PublishResult<B> map(Function<T, B> f) {
        try {
            return new PublishSuccess<>(f.apply(value));
        } catch (RuntimeException ex) {
            return new PublishFailure<>(ex);
        } catch (Exception ex) {
            return new PublishFailure<>(new RuntimeException(ex));
        }
    }

    @Override
    public <B> PublishResult<B> flatMap(Function<T, PublishResult<B>> f) {
        try {
            return f.apply(value);
        } catch (RuntimeException ex) {
            return new PublishFailure<>(ex);
        } catch (Exception ex) {
            return new PublishFailure<>(new RuntimeException(ex));
        }
    }

    @Override
    public String toString() {
        return "PublishSuccess{" +
                "value=" + value +
                '}';
    }
}
