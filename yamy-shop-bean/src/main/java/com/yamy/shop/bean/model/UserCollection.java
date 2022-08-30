package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/28 13:09
 */
@Data
@TableName("tz_user_collection")
public class UserCollection implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 收藏表ID
     */
    @TableId
    private Long id;

    /**
     * 商品ID
     */
    private Long prodId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 收藏时间
     */
    private Date creatTime;
}
