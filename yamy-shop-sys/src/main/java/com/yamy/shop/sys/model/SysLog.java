package com.yamy.shop.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/14 15:38
 */
@Data
@TableName("tz_sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 执行时长（毫秒）
     */
    private Long time;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 创建时间
     */
    private Date createDate;
}
