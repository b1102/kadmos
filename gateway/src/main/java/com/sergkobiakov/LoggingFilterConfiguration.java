package com.sergkobiakov;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingFilterConfiguration {
    @Bean
    public GlobalFilter filter() {
        return (exchange, chain) -> chain.filter(exchange);
    }
}
