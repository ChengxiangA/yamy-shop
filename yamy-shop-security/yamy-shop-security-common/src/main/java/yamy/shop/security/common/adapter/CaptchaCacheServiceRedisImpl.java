package yamy.shop.security.common.adapter;

import com.anji.captcha.service.CaptchaCacheService;
import com.yamy.shop.common.util.RedisUtil;

/**
 * @author 程祥
 * @date 2022/8/31 14:28
 */
public class CaptchaCacheServiceRedisImpl implements CaptchaCacheService {
    @Override
    public void set(String key, String value, long expiresInSeconds) {
        RedisUtil.set(key, value, expiresInSeconds);
    }

    @Override
    public boolean exists(String key) {
        return RedisUtil.hasKey(key);
    }

    @Override
    public void delete(String key) {
        RedisUtil.del(key);
    }

    @Override
    public String get(String key) {
        return RedisUtil.get(key);
    }

    @Override
    public String type() {
        return "redis";
    }
}