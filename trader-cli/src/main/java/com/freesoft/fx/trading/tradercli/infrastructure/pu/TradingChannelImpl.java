package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.application.TradingChannel;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.HazelcastExecutor;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.HazelcastRequest;
import reactor.core.publisher.Mono;

public class TradingChannelImpl implements TradingChannel {

    private final HazelcastExecutor hazelcastExecutor;

    TradingChannelImpl(HazelcastExecutor hazelcastExecutor) {
        this.hazelcastExecutor = hazelcastExecutor;
    }

    @Override
    public Mono<BuySucceeded> buy(TraderId trader, Mono<TradeCommand.BuyCommand> buyCommand) {
        return buyCommand.flatMap(command -> hazelcastExecutor.execute(HazelcastRequest.of(trader, command)));
    }

    @Override
    public Mono<SellSucceeded> sell(TraderId trader, Mono<TradeCommand.SellCommand> sellCommand) {
        return sellCommand.flatMap(command -> hazelcastExecutor.execute(HazelcastRequest.of(trader, command)));
    }
}
