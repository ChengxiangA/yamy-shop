/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */
package yamy.shop.security.common.manager;

import cn.hutool.crypto.symmetric.AES;
import com.yamy.shop.common.exception.YamyShopBindException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 密码加密使用 AES加密算法
 * 密钥：-mall4j-password
 */
@Component
public class PasswordManager {
    private static final Logger logger = LoggerFactory.getLogger(PasswordManager.class);

    /**
     * 用于aes签名的key，16位
     */
    @Value("${auth.password.signKey:-mall4j-password}")
    public String passwordSignKey;

    public String decryptPassword(String data) {
        AES aes = new AES(passwordSignKey.getBytes(StandardCharsets.UTF_8));
        String decryptStr;
        String decryptPassword;
        try {
            decryptStr = aes.decryptStr(data);
            decryptPassword = decryptStr.substring(13);
        } catch (Exception e) {
            logger.error("Exception:", e);
            throw new YamyShopBindException("AES解密错误", e);
        }
        return decryptPassword;
    }
}
