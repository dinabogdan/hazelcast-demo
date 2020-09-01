package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import java.util.concurrent.Callable;

public class HazelcastRequest<T> {
    private String partitioningKey;
    private Callable<T> task;

    private HazelcastRequest() {
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

    public static class HazelcastRequestBuilder<T> {
        private final HazelcastRequest<T> hazelcastRequest;

        public HazelcastRequestBuilder(HazelcastRequest<T> hazelcastRequest) {
            this.hazelcastRequest = hazelcastRequest;
        }

        public static HazelcastRequestBuilder<?> newInstance() {
            return new HazelcastRequestBuilder<>(new HazelcastRequest<>());
        }

        public HazelcastRequestBuilder<?> withPartitioningKey(String partitioningKey) {
            this.hazelcastRequest.setPartitioningKey(partitioningKey);
            return this;
        }

        public HazelcastRequestBuilder<?> withTask(Callable<T> task) {
            this.hazelcastRequest.setTask(task);
            return this;
        }
    }
}
