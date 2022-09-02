package com.yamy.shop.bean.enums;

/**
 * 运费收费方式 （0 按件数,1 按重量 2 按体积）
 * @author 程祥
 * @date 2022/8/30 10:11
 */
public enum TransportChargeType {

    /**
     * 0 记件
     */
    COUNT(0),

    /**
     * 1 按重量
     */
    WEIGHT(1),

    /**
     * 2 按体积
     */
    VOLUME(2)
    ;

    private Integer num;

    public Integer value() {
        return num;
    }

    TransportChargeType(Integer num){
        this.num = num;
    }

    public static TransportChargeType instance(Integer value) {
        TransportChargeType[] enums = values();
        for (TransportChargeType statusEnum : enums) {
            if (statusEnum.value().equals(value)) {
                return statusEnum;
            }
        }
        return null;
    }
}
