package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import java.io.Serializable;
import java.util.concurrent.Callable;

import com.freesoft.fx.trading.tradercli.api.model.BuyCommand;
import com.freesoft.fx.trading.tradercli.api.model.BuySucceeded;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

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
}
