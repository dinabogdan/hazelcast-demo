package com.freesoft.fx.trading.tradercli.application;

import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import reactor.core.publisher.Mono;

public interface TradingChannel {

    Mono<BuySucceeded> buy(TraderId trader, Mono<TradeCommand.BuyCommand> buyCommand);

    Mono<SellSucceeded> sell(TraderId trader, Mono<TradeCommand.SellCommand> sellCommand);
}
