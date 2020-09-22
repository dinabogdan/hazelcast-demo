package com.freesoft.fx.trading.tradercli.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class TradingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TradingHandler tradingHandler) {
        return RouterFunctions.route(POST("/api/buy").and(accept(MediaType.APPLICATION_JSON)), tradingHandler::buy)
                .andRoute(POST("/api/sell").and(accept(MediaType.APPLICATION_JSON)), tradingHandler::sell);
    }
}
