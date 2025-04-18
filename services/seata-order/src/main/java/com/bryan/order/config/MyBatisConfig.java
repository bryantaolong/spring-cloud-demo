package com.bryan.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: MyBatisConfig
 * Package: com.bryan.order.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:18
 * Version: v1.0
 */
@EnableTransactionManagement
@MapperScan("com.bryan.order.mapper")
@Configuration
public class MyBatisConfig {
}
