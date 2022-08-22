package com.yamy.shop.bean.enums;

/**
 * @author 程祥
 * @date 2022/8/20 15:03
 */
public enum ProdPropRule {

    // 规格属性(用于商品商品发布时关联sku)
    SPEC(1),
    // 规格参数(用于商品搜索时，与分类关联搜索)
    ATTRIBUTE(2);

    private Integer num;

    ProdPropRule(Integer num) {
        this.num = num;
    }

    public Integer value() {
        return num;
    }

    public static ProdPropRule instance(Integer value) {
        ProdPropRule[] values = values();
        for (ProdPropRule prodPropRule : values) {
            if(value.equals(prodPropRule.value())) {
                return prodPropRule;
            }
        }
        return null;
    }
}
