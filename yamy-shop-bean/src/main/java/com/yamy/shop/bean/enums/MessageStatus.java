package com.yamy.shop.bean.enums;

/**
 * @author 程祥
 * @date 2022/8/30 10:25
 */
public enum MessageStatus {

    /**
     * 小程序
     */
    CANCEL(0),
    RELEASE(1);

    private Integer num;

    public Integer value() {
        return num;
    }

    MessageStatus(Integer num){
        this.num = num;
    }
}

