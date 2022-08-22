package com.yamy.shop.bean.enums;

/**
 * @author 程祥
 * @date 2022/8/21 11:00
 */
public enum AreaLevelEnum {
    /**
     * 第一层
     */
    FIRST_LEVEL(1),

    /**
     * 第二层
     */
    SECOND_LEVEL(2),

    /**
     * 第三层
     */
    THIRD_LEVEL(3);
    private Integer num;


    AreaLevelEnum(Integer num) {
        this.num = num;
    }

    public Integer value() {
        return num;
    }

    public static AreaLevelEnum instance(Integer num) {
        AreaLevelEnum[] values = values();
        for (AreaLevelEnum value : values) {
            if(value.value().equals(num)) {
                return value;
            }
        }
        return null;
    }
}
