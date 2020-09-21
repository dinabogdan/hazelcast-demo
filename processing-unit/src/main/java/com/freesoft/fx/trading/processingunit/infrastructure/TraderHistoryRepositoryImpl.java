package com.freesoft.fx.trading.processingunit.infrastructure;

import com.freesoft.fx.trading.processingunit.domain.TraderHistoryRepository;
import com.freesoft.fx.trading.tradercli.api.model.Command;
import com.freesoft.fx.trading.tradercli.api.model.TraderRefId;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraderHistoryRepositoryImpl implements TraderHistoryRepository {
    private static final Logger log = LoggerFactory.getLogger(TraderHistoryRepositoryImpl.class);

    private final HazelcastInstance hazelcastInstance;

    TraderHistoryRepositoryImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public List<Command> findAll(TraderRefId trader) {
        log.info("Retrievig trading history for " + trader);
        return new ArrayList<>(getMap().values());
    }

    @Override
    public void add(Command command) {
        log.info("Add " + command + " to trader's " + command.getTraderRefId() + " history");
        getMap().put(command.getTraderRefId().getValue(), command);
    }

    private IMap<String, Command> getMap() {
        return hazelcastInstance.getMap("TRADER_HISTORY_MAP");
    }
}
