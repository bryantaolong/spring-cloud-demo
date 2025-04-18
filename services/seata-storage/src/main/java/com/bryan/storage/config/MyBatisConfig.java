package com.bryan.storage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: MyBatisConfig
 * Package: com.bryan.storage.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:32
 * Version: v1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.bryan.storage.mapper")
public class MyBatisConfig {
}
