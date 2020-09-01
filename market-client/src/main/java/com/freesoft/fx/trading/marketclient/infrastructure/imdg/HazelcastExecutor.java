package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import com.hazelcast.core.HazelcastInstance;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class HazelcastExecutor {

    private final HazelcastInstance hazelcastInstance;
    private final ImdgProperties imdgProperties;

    public HazelcastExecutor(HazelcastInstance hazelcastInstance, ImdgProperties imdgProperties) {
        this.hazelcastInstance = hazelcastInstance;
        this.imdgProperties = imdgProperties;
    }

    public <T> Mono<T> execute(HazelcastRequest<T> request) {
        var result = new CompletableFuture<T>();

        try {
            var executorService = hazelcastInstance.getExecutorService(imdgProperties.executorServiceName());
            executorService.submit(request.getTask(), new CompletableFutureExecutionCallback<>(result));
        } catch (Exception ex) {
            result.completeExceptionally(ex);
        }

        return Mono.fromFuture(result);
    }
}
