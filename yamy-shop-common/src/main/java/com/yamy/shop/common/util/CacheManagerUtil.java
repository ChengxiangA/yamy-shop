package com.yamy.shop.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @author 程祥
 * @date 2022/8/30 11:44
 */
@Component
public class CacheManagerUtil {
    @Autowired
    private CacheManager cacheManager;

    public <T> T getCache(String cacheName,String key) {
        Cache cache = cacheManager.getCache(cacheName);
        if(cache == null) {
            return null;
        }
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if(valueWrapper == null) {
            return null;
        }
        return (T) valueWrapper.get();
    }

    public void putCache(String cacheName,String key,Object value) {
        Cache cache = cacheManager.getCache(cacheName);
        if(cache != null) {
            cache.put(key,value);
        }
    }

    public void evictCache(String cacheName,String key) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.evict(key);
        }
    }
}
