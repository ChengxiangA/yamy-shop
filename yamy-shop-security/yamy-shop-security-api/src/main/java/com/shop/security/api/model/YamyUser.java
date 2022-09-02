package com.shop.security.api.model;

import lombok.Data;

/**
 * @author 程祥
 * @date 2022/8/31 16:44
 */
@Data
public class YamyUser {
    /**
     * 用户ID
     */
    private String userId;

    private String bizUserId;

    private Boolean enabled;

    /**
     * 自提点Id
     */
    private Long stationId;

    /**
     * 店铺Id
     */
    private Long shopId;
}
