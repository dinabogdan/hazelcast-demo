package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.api.model.SellCommand;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.api.model.TraderRefId;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.Callable;

@SpringAware
public class SellTask implements Callable<SellSucceeded>, Serializable {
    private static final long serialVersionUID = -3213576343319161714L;

    private SellCommand command;

    @Autowired
    private transient Trader trader;

    SellTask(SellCommand command) {
        this.command = command;
    }

    @Override
    public SellSucceeded call() throws Exception {
        return trader.sell(command);
    }

    public static SellTask of(TraderId trader, TradeCommand.SellCommand command) {
        var traderRefId = new TraderRefId(trader.getValue());
        var units = command.getPayload().getUnits();
        var quotePair = QuotePair.valueOf(command.getPayload().getQuoteItem().name());
        SellCommand sellCommand = new SellCommand(traderRefId, units, quotePair);
        return new SellTask(sellCommand);
    }
}
