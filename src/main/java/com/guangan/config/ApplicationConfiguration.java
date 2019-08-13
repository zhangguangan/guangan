package com.guangan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProcessorApspect processorApspect() {
        return new ProcessorApspect();
    }
}
