package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import com.hazelcast.core.ExecutionCallback;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExecutionCallback<T> implements ExecutionCallback<T> {

    private final CompletableFuture<T> completableFuture;

    public CompletableFutureExecutionCallback(CompletableFuture<T> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public void onResponse(T response) {
        completableFuture.complete(response);
    }

    @Override
    public void onFailure(Throwable t) {
        completableFuture.completeExceptionally(t);
    }
}
