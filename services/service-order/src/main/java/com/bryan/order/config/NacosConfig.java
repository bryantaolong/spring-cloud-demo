package com.bryan.order.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ClassName: NacosConfig
 * Package: com.bryan.order.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 16:39
 * Version: v1.0
 */
@Configuration
@EnableDiscoveryClient //核心注解
public class NacosConfig {

    @Bean
    public ApplicationRunner applicationRunner(NacosConfigManager manager){
        return args -> {
            ConfigService configService = manager.getConfigService();

            configService.addListener("service-order.yaml", "DEFAULT_GROUP", new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(4);
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("configInfo = " + configInfo);
                }
            });
        };
    }

}
