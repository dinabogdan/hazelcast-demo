package com.freesoft.fx.trading.tradercli.infrastructure.imdg;

import java.util.concurrent.Callable;

import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.freesoft.fx.trading.tradercli.infrastructure.pu.ProcessingUnitTaskMapper;

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

    public static <R> HazelcastRequest<R> of(String partitioningKey, Callable<R> task) {
        return new HazelcastRequest<>(partitioningKey, task);
    }

    public Callable<T> getTask() {
        return task;
    }

    public static HazelcastRequest<BuySucceeded> of(TraderId trader, TradeCommand.BuyCommand command) {
        return HazelcastRequest.of(trader.getValue(), ProcessingUnitTaskMapper.buyTaskOf(trader, command));

    }

    public static HazelcastRequest<SellSucceeded> of(TraderId trader, TradeCommand.SellCommand command) {
        return HazelcastRequest.of(trader.getValue(), ProcessingUnitTaskMapper.sellTaskOf(trader, command));
    }
}
