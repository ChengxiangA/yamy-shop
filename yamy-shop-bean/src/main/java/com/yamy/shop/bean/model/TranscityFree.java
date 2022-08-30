package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 程祥
 * @date 2022/8/28 12:53
 */
@Data
@TableName("tz_transcity_free")
public class TranscityFree implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long transcityFreeId;

    /**
     * 指定条件包邮项目id
     */
    private Long transfeeFreeId;

    /**
     * 城市ID
     */
    private Long cityId;

    @TableField(exist = false)
    private String cityName;
}
