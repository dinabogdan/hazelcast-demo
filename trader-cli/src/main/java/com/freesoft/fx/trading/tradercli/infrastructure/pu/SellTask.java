package com.freesoft.fx.trading.tradercli.infrastructure.pu;

import java.io.Serializable;
import java.util.concurrent.Callable;

import com.freesoft.fx.trading.tradercli.api.model.SellCommand;
import com.freesoft.fx.trading.tradercli.api.model.SellSucceeded;
import com.freesoft.fx.trading.tradercli.api.service.Trader;
import com.hazelcast.spring.context.SpringAware;
import org.springframework.beans.factory.annotation.Autowired;

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
}
