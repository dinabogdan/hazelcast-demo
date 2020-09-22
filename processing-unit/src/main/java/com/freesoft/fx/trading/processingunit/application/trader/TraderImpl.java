package com.freesoft.fx.trading.processingunit.application.trader;

import com.freesoft.fx.trading.processingunit.domain.TraderHistoryRepository;
import com.freesoft.fx.trading.tradercli.api.model.*;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TraderImpl extends Trader {

    private final TraderHistoryRepository traderHistoryRepository;

    TraderImpl(TraderHistoryRepository traderHistoryRepository) {
        this.traderHistoryRepository = traderHistoryRepository;
    }

    @Override
    protected BuySucceeded buy(BuyCommand buyCommand) {
        traderHistoryRepository.add(buyCommand);
        return new BuySucceeded(new DateTime(LocalDateTime.now()));
    }

    @Override
    protected SellSucceeded sell(SellCommand sellCommand) {
        traderHistoryRepository.add(sellCommand);
        return new SellSucceeded(new DateTime(LocalDateTime.now()));
    }


}
