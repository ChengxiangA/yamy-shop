package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/27 16:57
 */
@Data
@TableName("tz_transfee_free")
public class TransfeeFree implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 指定条件包邮项id
     */
    @TableId
    private Long transfeeFreeId;

    /**
     * 运费模板id
     */
    private Long transportId;

    /**
     * 包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     */
    private Integer freeType;


    /**
     * 需满金额
     */
    private Double amount;

    /**
     * 包邮x件/重量/数目
     */
    private Double piece;

    /**
     * 指定条件包邮城市项
     */
    @TableField(exist = false)
    private List<Area> freeCityList;
}
