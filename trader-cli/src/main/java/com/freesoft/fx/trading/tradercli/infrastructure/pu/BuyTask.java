package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import com.freesoft.fx.trading.tradercli.api.model.BuyCommand;
import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.api.model.TraderRefId;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.Callable;

@SpringAware
public class BuyTask implements Callable<BuySucceeded>, Serializable {
    private static final long serialVersionUID = -321344656719164314L;

    private BuyCommand command;

    @Autowired
    private transient Trader trader;

    BuyTask(BuyCommand command) {
        this.command = command;
    }

    @Override
    public BuySucceeded call() throws Exception {
        return trader.buy(command);
    }

    public static BuyTask of(TraderId trader, TradeCommand.BuyCommand command) {
        var traderRefId = new TraderRefId(trader.getValue());
        var units = command.getPayload().getUnits();
        var quotePair = QuotePair.valueOf(command.getPayload().getQuoteItem().name());
        BuyCommand buyCommand = new BuyCommand(traderRefId, units, quotePair);
        return new BuyTask(buyCommand);
    }
}
