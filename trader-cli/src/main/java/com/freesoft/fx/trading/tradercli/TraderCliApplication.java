package com.freesoft.fx.trading.tradercli;

import com.freesoft.fx.trading.tradercli.infrastructure.imdg.HazelcastProperties;
import com.freesoft.fx.trading.tradercli.infrastructure.imdg.TcpProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({HazelcastProperties.class, TcpProperties.class})
public class TraderCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraderCliApplication.class, args);
    }

}
