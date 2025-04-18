package com.bryan.business.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: OpenFeignConfig
 * Package: com.bryan.business.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:13
 * Version: v1.0
 */
@Configuration
@EnableFeignClients(basePackages = "com.bryan.business.client")
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
