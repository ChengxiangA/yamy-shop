package com.yamy.shop.bean.enums;

/**
 * 支付类型
 * @author 程祥
 * @date 2022/8/30 10:21
 */
public enum PayType {
    WECHATPAY(1,"微信支付"),

    ALIPAY(2,"支付宝");

    private Integer num;

    private String payTypeName;

    public Integer value() {
        return num;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    PayType(Integer num,String payTypeName){
        this.num = num;
        this.payTypeName = payTypeName;
    }

    public static PayType instance(Integer value) {
        PayType[] enums = values();
        for (PayType statusEnum : enums) {
            if (statusEnum.value().equals(value)) {
                return statusEnum;
            }
        }
        return null;
    }
}
