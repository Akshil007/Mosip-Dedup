package com.pe.mosip.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class threadConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(255);
        executor.setMaxPoolSize(255);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("MyRequestThread");
        executor.initialize();
        return executor;
    }
}
