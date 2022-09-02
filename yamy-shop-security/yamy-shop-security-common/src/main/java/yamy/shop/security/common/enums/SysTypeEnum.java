package yamy.shop.security.common.enums;

/**
 * @author 程祥
 * @date 2022/8/30 21:31
 */
public enum SysTypeEnum {
    /**
     * 普通用户
     */
    ORDINARY(0),

    /**
     * 管理员
     */
    ADMIN(1),
    ;

    private final Integer value;

    public Integer value() {
        return value;
    }

    SysTypeEnum(Integer value) {
        this.value = value;
    }
}
