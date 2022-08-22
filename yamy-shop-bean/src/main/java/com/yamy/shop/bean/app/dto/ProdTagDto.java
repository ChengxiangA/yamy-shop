package com.yamy.shop.bean.app.dto;

/**
 * @author 程祥
 * @date 2022/8/19 13:38
 */
public class ProdTagDto {
    private Long id;

    private String title;

    /**
     * 数值越高越排前
     */
    private String seq;

    /**
     * 0:一列一个,1:一列两个,2:一列三个
     */
    private String style;
}
