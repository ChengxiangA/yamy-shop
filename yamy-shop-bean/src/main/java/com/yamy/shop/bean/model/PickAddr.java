package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 程祥
 * @date 2022/8/21 21:46
 */
@Data
@TableName("tz_pick_addr")
public class PickAddr implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long addrId;

    /**
     * 自提点名称
     */
    private String addrName;

    /**
     * 地址（在区/县上面细化的地址）
     */
    private String addr;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 省份ID
     */
    private Long provinceId;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市
     */
    private String city;

    /**
     * 区/县ID
     */
    private Long areaId;

    /**
     * 区
     */
    private String area;

    /**
     * 店铺ID
     */
    private Long shopId;
}
