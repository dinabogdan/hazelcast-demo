package com.freesoft.fx.trading.processingunit.application.trader;

import java.time.LocalDateTime;

import com.freesoft.fx.trading.processingunit.domain.TraderHistoryRepository;
import com.freesoft.fx.trading.tradercli.api.model.BuyCommand;
import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.DateTime;
import com.freesoft.fx.trading.tradercli.api.model.SellCommand;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import org.springframework.stereotype.Component;

@Component
public class TraderImpl extends Trader {

    private final TraderHistoryRepository traderHistoryRepository;

    TraderImpl(TraderHistoryRepository traderHistoryRepository) {
        this.traderHistoryRepository = traderHistoryRepository;
    }

    @Override
    public BuySucceeded buy(BuyCommand buyCommand) {
        traderHistoryRepository.add(buyCommand);
        return new BuySucceeded(new DateTime(LocalDateTime.now()));
    }

    @Override
    public SellSucceeded sell(SellCommand sellCommand) {
        traderHistoryRepository.add(sellCommand);
        return new SellSucceeded(new DateTime(LocalDateTime.now()));
    }
}
