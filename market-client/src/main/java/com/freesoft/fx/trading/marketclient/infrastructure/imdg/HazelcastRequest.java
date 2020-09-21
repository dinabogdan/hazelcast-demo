package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import java.util.concurrent.Callable;

public class HazelcastRequest<T> {
    private String partitioningKey;
    private Callable<T> task;

    private HazelcastRequest() {
    }

    private HazelcastRequest(Callable<T> task) {
        this.task = task;
    }

    private HazelcastRequest(String partitioningKey, Callable<T> task) {
        this.partitioningKey = partitioningKey;
        this.task = task;
    }

    private void setPartitioningKey(String partitioningKey) {
        this.partitioningKey = partitioningKey;
    }

    private void setTask(Callable<T> task) {
        this.task = task;
    }

    String getPartitioningKey() {
        return partitioningKey;
    }

    Callable<T> getTask() {
        return task;
    }

    public static <R> HazelcastRequest<R> of(Callable<R> task) {
        return new HazelcastRequest<>(task);
    }
}
