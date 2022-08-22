package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/22 13:39
 */
@Data
@TableName("tz_transport")
public class TransPort implements Serializable {
    public static final long serialVersionUid = 1L;

    @TableId
    private long transportId;

    private String transName;

    private Date createTime;

    private long shopId;

    private Integer isFreeFee;


}
