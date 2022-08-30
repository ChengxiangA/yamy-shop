package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/27 16:57
 */
@Data
public class TransFee implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 运费险ID
     */
    @TableId
    private Long transFeeId;

    /**
     * 运费模板ID
     */
    private Long transportId;

    /**
     * 首件数量(首件体积、首件重量)
     */
    private Double firstPiece;

    /**
     * 首件费用
     */
    private Double firstFee;

    /**
     * 续件数量(续件体积、续件重量)
     */

    private Double continuousPiece;


    /**
     * 续件费用
     */
    private Double continuousFee;

    /**
     * 指定条件运费项的城市
     */
    @TableField(exist = false)
    private List<Area> cityList;
}
