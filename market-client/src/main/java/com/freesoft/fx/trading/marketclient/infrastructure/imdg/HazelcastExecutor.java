package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class HazelcastExecutor {

    private final HazelcastInstance hazelcastInstance;
    private final HazelcastProperties hazelcastProperties;

    HazelcastExecutor(HazelcastInstance hazelcastInstance, HazelcastProperties hazelcastProperties) {
        this.hazelcastInstance = hazelcastInstance;
        this.hazelcastProperties = hazelcastProperties;
    }

    public <T> Mono<T> execute(HazelcastRequest<T> request) {
        var result = new CompletableFuture<T>();

        try {
            var executorService = hazelcastInstance.getExecutorService(hazelcastProperties.getExecutorServiceName());
            executorService.submit(request.getTask(), new CompletableFutureExecutionCallback<>(result));
        } catch (Exception ex) {
            result.completeExceptionally(ex);
        }

        return Mono.fromFuture(result);
    }
}
