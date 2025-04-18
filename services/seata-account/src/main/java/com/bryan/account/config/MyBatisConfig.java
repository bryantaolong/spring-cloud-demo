package com.bryan.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MyBatisConfig
 * Package: com.bryan.account.config
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:22
 * Version: v1.0
 */
@Configuration
@MapperScan("com.bryan.account.mapper")
public class MyBatisConfig {
}
