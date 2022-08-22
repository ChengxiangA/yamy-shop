package com.yamy.shop.security.admin.model;

import lombok.Data;

import java.util.Set;

/**
 * @author 程祥
 * @date 2022/8/17 8:46
 */
@Data
public class YamySysUser {
    /**
     * 用户ID
     */
    private Long userId;

    private boolean enabled;

    private Set<String> authorities;
    
    private String username;

    private Long shopId;
}
