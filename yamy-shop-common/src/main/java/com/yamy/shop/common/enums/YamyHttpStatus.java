package com.yamy.shop.common.enums;

/**
 * @author 程祥
 * @date 2022/8/18 12:51
 */
public enum YamyHttpStatus {

    /**
     * 客户端看到401状态码时，应该重新登陆
     */
    UNAUTHORIZED(401, "未授权"),

    COUPONCANNOTUSETOGETHER(601, "优惠券不能共用"),

    SOCIAL_ACCOUNT_NOT_BIND(475, "social account not bind"),

    ACCOUNT_NOT_REGISTER(476, "account not register"),
    ;
    private final int value;

    private final String msg;

    YamyHttpStatus(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int value() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    public static YamyHttpStatus valueOf(int httpStatusCode) {
        YamyHttpStatus status = YamyHttpStatus.resolve(httpStatusCode);
        if(status == null) {
            throw new IllegalArgumentException("没有找到该状态码:[" + httpStatusCode + "]所包含的HttpStatus状态");
        }
        return status;
    }

    public static YamyHttpStatus resolve(int httpStatusCode) {
        for(YamyHttpStatus status: values()) {
            if(status.value() == httpStatusCode) {
                return status;
            }
        }
        return null;
    }
}
