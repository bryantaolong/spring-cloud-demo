package com.bryan.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ProductConfig
 * Package: com.bryan.product.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 11:32
 * Version: v1.0
 */
@Configuration
public class ProductConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
