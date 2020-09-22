package com.freesoft.fx.trading.tradercli.api;

import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.application.TradingChannel;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TradingHandler {

    private final TraderId traderId;
    private final TradingChannel tradingChannel;

    public TradingHandler(TraderId traderId, TradingChannel tradingChannel) {
        this.traderId = traderId;
        this.tradingChannel = tradingChannel;
    }

    public Mono<ServerResponse> buy(ServerRequest request) {
        return ServerResponse.ok().body(tradingChannel.buy(traderId, request.bodyToMono(TradeCommand.BuyCommand.class)), BuySucceeded.class);
    }

    public Mono<ServerResponse> sell(ServerRequest request) {
        return ServerResponse.ok().body(tradingChannel.sell(traderId, request.bodyToMono(TradeCommand.SellCommand.class)), SellSucceeded.class);
    }

}
