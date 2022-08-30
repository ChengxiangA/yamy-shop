package com.yamy.shop.common.util;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author 程祥
 * @date 2022/8/23 13:00
 */
public class RedisUtil {
    private static RedisTemplate<String,Object> redisTemplate = SpringContextUtil.getBean("redisTemplate",RedisTemplate.class);

    /**
     *  指定缓存失效时间
     */
    public static boolean expire(String key,long time) {
        redisTemplate.expire(key,time, TimeUnit.SECONDS);
        return true;
    }

    /**
     * 返回缓存过期时间
     */
    public static long getExpire(String key) {
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断是否有对应的key
     */
    public static boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除一个或者多个缓存
     */
    public static void del(String... key) {
        if(key != null && key.length > 0) {
            if(key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存获取
     */
    public static <T> T get(String key) {
        return key == null ? null : (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入,不过期
     */
    public static boolean set(String key,Object value) {
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    /**
     * 普通缓存放入，并设置过期时间
     */
    public static boolean set(String key,Object value,long expireTime) {
        if(expireTime > 0) {
            redisTemplate.opsForValue().set(key,value,expireTime);
        } else {
            redisTemplate.opsForValue().set(key,value);
        }
        return true;
    }

    /**
     * 设置key递增步长，value必须为int类型（数字字符串）
     */
    public static long incr(String key,long delta) {
        if(delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 设置key递减步长，value为int类型
     */
    public static long decr(String key,long delta) {
        if(delta > 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key,delta);
    }
}
