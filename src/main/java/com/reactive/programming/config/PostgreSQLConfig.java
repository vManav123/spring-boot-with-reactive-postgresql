package com.reactive.programming.config;

import io.r2dbc.spi.*;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@Slf4j
public class PostgreSQLConfig {
//    @Bean
//    public ConnectionFactory connectionFactory() {
//
//        String schema = "product";
//
//        ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
//                .option(DRIVER, "postgresql")
//                .option(HOST, "localhost")
//                .option(PORT, 5432)  // optional, defaults to 5432
//                .option(USER, "postgres")
//                .option(PASSWORD, "root")
//                .option(DATABASE, "testing")  // optional
//                .option(Option.sensitiveValueOf("schema"), schema) // optional
//                .build());
//        log.info("Database Connection ✔");
//        Publisher<? extends Connection> connectionPublisher = connectionFactory.create();
//
//
//        // Alternative: Creating a Mono using Project Reactor
//        Mono<Connection> connectionMono = Mono.from(connectionFactory.create());
//        return connectionFactory;
//    }
}
