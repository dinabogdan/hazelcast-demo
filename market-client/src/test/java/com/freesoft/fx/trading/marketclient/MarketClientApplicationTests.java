package com.freesoft.fx.trading.marketclient;

import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MarketClientApplicationTests {

    @Autowired
    private HazelcastProperties hazelcastProperties;

    @Test
    void contextLoads() {
        assertNotNull(hazelcastProperties);
    }

}
