package com.freesoft.fx.trading.processingunit;

import com.freesoft.fx.trading.processingunit.infrastructure.imdg.HazelcastConfigurationProperties;
import com.freesoft.fx.trading.processingunit.infrastructure.imdg.TcpProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({HazelcastConfigurationProperties.class, TcpProperties.class})
public class ProcessingUnitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessingUnitApplication.class, args);
    }

}
