package com.freesoft.fx.trading.processingunit.domain;

import com.freesoft.fx.trading.tradercli.api.model.Command;
import com.freesoft.fx.trading.tradercli.api.model.TraderRefId;

import java.util.List;

public interface TraderHistoryRepository {

    List<Command> findAll(TraderRefId trader);

    void add(Command command);
}
