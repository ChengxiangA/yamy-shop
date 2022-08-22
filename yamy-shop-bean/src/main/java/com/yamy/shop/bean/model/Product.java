package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yamy.shop.common.serializer.json.ImgJsonSerializer;
import lombok.Data;
import me.chanjar.weixin.mp.bean.card.Sku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/18 19:28
 */
@Data
@TableName("tz_prod")
public class Product implements Serializable {
    private static final long serialVersionUID = -4644407386444894349L;

    /**
     * 产品ID
     */
    @TableId
    private Long prodId;

    private Long shopId;

    private String prodName;

    private Double price;

    /**
     * 原价
     */
    private Double oriPrice;

    /**
     * 卖点、简述
     */
    private String brief;

    /**
     * 商品主图
     */
    @JsonSerialize(using = ImgJsonSerializer.class)
    private String pic;

    /**
     * 商品图片
     */
    @JsonSerialize(using = ImgJsonSerializer.class)
    private String imgs;

    /**
     * 默认为1，上架状态， -1表示删除  0下架
     */
    private Integer status;

    /**
     * 商品分类
     */
    private Long categoryId;

    /**
     * 销售数量
     */
    private Integer soldNum;

    /**
     * 库存
     */
    private Integer totalStocks;

    /**
     * 配送模式
     */
    private String deliveryMode;

    /**
     * 运费模板ID
     */
    private Long deliveryTemplateId;

    /**
     * 录入时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 详细描述
     */
    private String content;

    /**
     * 上架时间
     */
    private Date putawayTime;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * sku列表
     */
    @TableField(exist = false)
    private List<Sku> skuList;

    /**
     * 店家名
     */
    @TableField(exist = false)
    private String shopName;

    /**
     * 标签列表
     */
    @TableField(exist = false)
    private List<Long> tagList;

    @Data
    public static class DeliveryModeVo {
        /**
         * 用户自提
         */
        private Boolean hasUserPickUp;

        /**
         * 商家配送
         */
        private Boolean hasShopDelivery;
    }
}
