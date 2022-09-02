package com.yamy.shop.admin.config;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 程祥
 * @date 2022/8/30 10:07
 */
@Configuration
public class AdminBeanConfig {
    @Autowired
    private AdminConfig adminConfig;

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(adminConfig.getWorkerId(), adminConfig.getDatacenterId());
    }
}
