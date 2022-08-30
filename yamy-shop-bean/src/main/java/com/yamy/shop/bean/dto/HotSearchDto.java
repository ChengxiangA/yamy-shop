package com.yamy.shop.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 程祥
 * @date 2022/8/24 23:32
 */
@Data
public class HotSearchDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long hotSearchId;

    private String title;

    private String content;
}
