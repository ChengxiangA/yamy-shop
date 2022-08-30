package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/22 13:39
 */
@Data
@TableName("tz_transport")
public class Transport implements Serializable {
    public static final long serialVersionUid = 1L;
    /**
     * 运费模板ID
     */
    @TableId
    private Long transportId;

    /**
     * 运费名称
     */
    private String transName;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     * 店铺ID
     */
    private Long shopId;


    /**
     * 收费方式
     * 收费方式（0 按件数,1 按重量 2 按体积）
     */
    private Integer chargeType;

    /**
     * 卖家是否包邮
     * 0：不包邮 1：包邮
     * 不包邮就很多复杂业务
     */
    private Integer isFreeFee;

    /**
     * 是否含有包邮条件
     */
    private Integer hasFreeCondition;

    /**
     * 指定条件包邮项
     */
    @TableField(exist = false)
    private List<TransfeeFree> transfeeFrees;


    /**
     * 运费项
     */
    @TableField(exist = false)
    private List<TransFee> transFees;

}
