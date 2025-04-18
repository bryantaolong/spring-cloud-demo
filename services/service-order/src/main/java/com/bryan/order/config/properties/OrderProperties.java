package com.bryan.order.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: OrderProperties
 * Package: com.bryan.order.config.properties
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 14:41
 * Version: v1.0
 */
@Component
@ConfigurationProperties(prefix = "order") //配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

    private String dbUrl;
}
