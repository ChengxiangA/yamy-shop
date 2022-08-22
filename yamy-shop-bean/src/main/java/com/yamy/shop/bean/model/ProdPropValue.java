package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 程祥
 * @date 2022/8/19 19:41
 */
@Data
@TableName("tz_prod_prop_value")
public class ProdPropValue implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 属性值ID
     */
    @TableId
    private Long valueId;

    /**
     * 属性值
     */
    private String propValue;

    /**
     * 属性ID
     */
    private String propId;
}
