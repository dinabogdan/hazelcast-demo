package com.freesoft.fx.trading.tradercli.api.service;

import com.freesoft.fx.trading.tradercli.api.model.BuyCommand;
import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.model.SellCommand;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;

public abstract class Trader {

    protected abstract BuySucceeded buy(BuyCommand command);

    protected abstract SellSucceeded sell(SellCommand command);
}
