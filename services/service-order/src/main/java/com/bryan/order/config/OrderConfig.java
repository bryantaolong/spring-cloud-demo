package com.bryan.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ProductServiceConfig
 * Package: com.bryan.order.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 11:24
 * Version: v1.0
 */
@Configuration
public class OrderConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
