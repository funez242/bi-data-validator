package com.finvivir.process.bi.unit.crosscutting.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * The class Async configuration.
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {
    /**
     * Async executor executor.
     *
     * @return the executor
     */
    @Bean
    public Executor asyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
