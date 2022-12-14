package com.yamy.shop.sys.constant;

/**
 * @author 程祥
 * @date 2022/8/15 19:31
 */
public enum MenuType {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);
    private int value;

    MenuType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
