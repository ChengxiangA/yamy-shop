package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 程祥
 * @date 2022/8/28 12:49
 */
@Data
@TableName("tz_transcity")
public class Transcity implements Serializable {

    @TableId
    private Long transcityId;

    /**
     * 运费项ID
     */
    private Long transfeeId;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市名称
     */
    @TableField(exist = false)
    private String cityName;
}
