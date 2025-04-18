package com.bryan.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * ClassName: EurekaServerTest
 * Package: com.bryan.eureka
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:23
 * Version: v1.0
 */
@SpringBootTest
public class EurekaServerTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void contextLoads() {
        System.out.println(getServiceUrl());
    }

    private String getServiceUrl() {
        List<ServiceInstance> instances = discoveryClient.getInstances("my-application");
        if (instances.isEmpty()) {
            return "No service available";
        }

        ServiceInstance instance = instances.get(0);
        return instance.getUri().toString();
    }
}
