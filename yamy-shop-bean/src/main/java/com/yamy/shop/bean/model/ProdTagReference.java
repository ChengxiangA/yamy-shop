package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/9/1 19:02
 */
@Data
public class ProdTagReference implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分组引用id
     */
    @TableId
    private Long referenceId;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 标签id
     */
    private Long tagId;
    /**
     * 商品id
     */
    private Long prodId;
    /**
     * 状态(1:正常,0:删除)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
}
