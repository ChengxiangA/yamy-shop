package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.ProdPropValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/19 19:46
 */
public interface ProdPropValueMapper extends BaseMapper<ProdPropValue> {
    int insertProdPropValues(@Param("id") Long PropId,@Param("prodPropValues") List<ProdPropValue> prodPropValues);

    /**
     * 根据属性Id删除对应所有属性值
     * @param propId
     */
    int deleteByPropId(@Param("prodId") Long propId);
}
