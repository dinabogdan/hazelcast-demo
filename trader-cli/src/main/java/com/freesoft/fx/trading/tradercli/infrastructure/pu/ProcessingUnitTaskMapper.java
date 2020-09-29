package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import com.freesoft.fx.trading.tradercli.api.model.BuyCommand;
import com.freesoft.fx.trading.tradercli.api.model.QuotePair;
import com.freesoft.fx.trading.tradercli.api.model.SellCommand;
import com.freesoft.fx.trading.tradercli.api.model.TraderRefId;
import com.freesoft.fx.trading.tradercli.application.model.TradeCommand;
import com.freesoft.fx.trading.tradercli.application.model.TraderId;

public class ProcessingUnitTaskMapper {

    public static BuyTask buyTaskOf(TraderId trader, TradeCommand.BuyCommand command) {
        var traderRefId = new TraderRefId(trader.getValue());
        var units = command.getPayload().getUnits();
        var quotePair = QuotePair.valueOf(command.getPayload().getQuoteItem().name());
        BuyCommand buyCommand = new BuyCommand(traderRefId, units, quotePair);
        return new BuyTask(buyCommand);
    }

    public static SellTask sellTaskOf(TraderId trader, TradeCommand.SellCommand command) {
        var traderRefId = new TraderRefId(trader.getValue());
        var units = command.getPayload().getUnits();
        var quotePair = QuotePair.valueOf(command.getPayload().getQuoteItem().name());
        SellCommand sellCommand = new SellCommand(traderRefId, units, quotePair);
        return new SellTask(sellCommand);
    }
}
