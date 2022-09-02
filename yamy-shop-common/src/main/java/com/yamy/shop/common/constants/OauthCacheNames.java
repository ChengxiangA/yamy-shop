package com.yamy.shop.common.constants;

/**
 * @author 程祥
 * @date 2022/8/30 14:50
 */
public class OauthCacheNames {
    /**
     * oauth 授权相关key
     */
    public static final String OAUTH_PREFIX = "mall4j_oauth:";

    /**
     * token 授权相关key
     */
    public static final String OAUTH_TOKEN_PREFIX = OAUTH_PREFIX + "token:";


    /**
     * 保存token 缓存使用key
     */
    public static final String ACCESS = OAUTH_TOKEN_PREFIX + "access:";

    /**
     * 刷新token 缓存使用key
     */
    public static final String REFRESH_TO_ACCESS = OAUTH_TOKEN_PREFIX + "refresh_to_access:";

    /**
     * 根据uid获取保存的token key缓存使用的key
     */
    public static final String UID_TO_ACCESS = OAUTH_TOKEN_PREFIX + "uid_to_access:";
}
