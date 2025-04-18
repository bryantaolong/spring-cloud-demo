package com.bryan.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * ClassName: LoadBalancerTest
 * Package: com.bryan.order
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 11:42
 * Version: v1.0
 */
@SpringBootTest
public class LoadBalancerClientTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient; // 默认采用轮询

    @Test
    public void test() {
        ServiceInstance chosen = loadBalancerClient.choose("service-product");
        System.out.println("chosen: " + chosen.getHost() + ":" + chosen.getPort());
    }

}
