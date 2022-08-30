package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/24 23:24
 */
@Data
@TableName("tz_hot_search")
public class HotSearch implements Serializable {
    @TableId
    private Long hotSearchId;

    private Long shopId;

    private String title;

    private String content;

    /**
     * 录入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recDate;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 状态 默认是1,0为下线
     */
    private Integer status;

}
