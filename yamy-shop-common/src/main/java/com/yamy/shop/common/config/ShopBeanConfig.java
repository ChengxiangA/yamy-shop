package com.yamy.shop.common.config;

import cn.hutool.crypto.symmetric.AES;
import com.yamy.shop.common.bean.ALiDaYu;
import com.yamy.shop.common.bean.Qiniu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 程祥
 * @date 2022/8/30 16:09
 */
@Configuration
public class ShopBeanConfig {
    @Autowired
    private ShopBasicConfig shopBasicConfig;

    @Bean
    public Qiniu qiniu() {
        return shopBasicConfig.getQiniu();
    }

    @Bean
    public AES tokenAes() {
        return new AES(shopBasicConfig.getTokenAesKey().getBytes());
    }

    @Bean
    public ALiDaYu aLiDaYu () {
        return shopBasicConfig.getALiDaYu();
    }
}
