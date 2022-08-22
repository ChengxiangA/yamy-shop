package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/20 14:23
 */
@Data
@TableName("tz_prod_prop")
public class ProdProp {
    /**
     * 属性ID
     */
    @TableId
    private long propId;

    /**
     * 属性名
     */
    @NotEmpty(message = "属性名不能为空")
    @Size(max = 20,message = "属性名长度不能超过{max}")
    private String propName;

    /**
     * 1.销售属性（规格） 2.参数属性
     */
    private Integer rule;

    private Long shopId;

    @TableField(exist = false)
    @NotEmpty(message = "规格属性不能为空")
    private List<ProdPropValue> prodPropValueList;
}
