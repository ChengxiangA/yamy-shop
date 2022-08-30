package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/28 12:59
 */
@Data
@TableName("tz_user_addr")
public class UserAddr implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Long addrId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 省ID
     */
    private Long provinceId;

    /**
     * 省
     */
    private String province;

    /**
     * 市ID
     */
    private Long cityId;

    /**
     * 市
     */
    private String city;

    /**
     * 区/县ID
     */
    private Long areaId;

    /**
     * 区/县
     */
    private String area;

    /**
     * 邮编
     */
    private String postCode;


    /**
     * 地址
     */
    private String addr;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 状态 1：正常  0：无效
     */
    private Integer status;

    /**
     * 是否默认地址 默认为1
     */
    private Integer commonAddr;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
