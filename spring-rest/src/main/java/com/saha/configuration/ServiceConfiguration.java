package com.saha.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }
}
