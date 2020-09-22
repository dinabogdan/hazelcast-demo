package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import com.hazelcast.core.HazelcastInstance;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class HazelcastExecutor {

    private final HazelcastInstance hazelcastInstance;
    private final HazelcastProperties hazelcastProperties;

    HazelcastExecutor(HazelcastInstance hazelcastInstance, HazelcastProperties hazelcastProperties) {
        this.hazelcastInstance = hazelcastInstance;
        this.hazelcastProperties = hazelcastProperties;
    }

    public <T> Mono<T> execute(HazelcastRequest<T> hazelcastRequest) {
        var result = new CompletableFuture<T>();

        try {
            var executorService = hazelcastInstance.getExecutorService(hazelcastProperties.getExecutorServiceName());

            executorService.submitToKeyOwner(hazelcastRequest.getTask(), hazelcastRequest.getPartitioningKey(), new CompletableFutureExecutionCallback<>(result));
        } catch (Exception ex) {
            result.completeExceptionally(ex);
        }

        return Mono.fromFuture(result);
    }
}
