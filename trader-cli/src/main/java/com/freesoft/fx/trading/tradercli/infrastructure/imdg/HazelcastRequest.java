package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.freesoft.fx.trading.tradercli.infrastructure.pu.BuyTask;
import com.freesoft.fx.trading.tradercli.infrastructure.pu.SellTask;

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

    public String getPartitioningKey() {
        return partitioningKey;
    }

    public static <R> HazelcastRequest<R> of(Callable<R> task) {
        return new HazelcastRequest<>(task);
    }

    public Callable<T> getTask() {
        return task;
    }

    public static HazelcastRequest<BuySucceeded> of(TraderId trader, TradeCommand.BuyCommand command) {
        return HazelcastRequest.of(BuyTask.of(trader, command));

    }

    public static HazelcastRequest<SellSucceeded> of(TraderId trader, TradeCommand.SellCommand command) {
        return HazelcastRequest.of(SellTask.of(trader, command));
    }
}
