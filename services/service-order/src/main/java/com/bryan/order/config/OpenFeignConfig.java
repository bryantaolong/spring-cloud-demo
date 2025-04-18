package com.bryan.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: OpenFeignConfig
 * Package: com.bryan.order.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 16:40
 * Version: v1.0
 */
@Configuration
@EnableFeignClients(basePackages = "com.bryan.order.client")
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }

}
