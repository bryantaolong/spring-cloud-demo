package com.bryan.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: NacosConfigCenterTest
 * Package: com.bryan.order
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 14:36
 * Version: v1.0
 */
@SpringBootTest
public class NacosConfigCenterTest {

    @Value("${order.timeout}")
    private String orderTimeout;

    @Test
    public void test() {
        System.out.println(orderTimeout);
    }
}
