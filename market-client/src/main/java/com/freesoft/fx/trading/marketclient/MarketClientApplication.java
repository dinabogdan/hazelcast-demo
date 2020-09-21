package com.freesoft.fx.trading.marketclient;

import com.freesoft.fx.trading.marketclient.infrastructure.imdg.HazelcastProperties;
import com.freesoft.fx.trading.marketclient.infrastructure.imdg.TcpProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({HazelcastProperties.class, TcpProperties.class})
public class MarketClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketClientApplication.class, args);
    }
}
