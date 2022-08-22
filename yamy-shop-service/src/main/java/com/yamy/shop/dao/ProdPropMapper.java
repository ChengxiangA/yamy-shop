package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.ProdProp;
import com.yamy.shop.common.util.PageAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/20 14:31
 */
public interface ProdPropMapper extends BaseMapper<ProdProp> {
    List<ProdProp> listPropAndValue(@Param("pageAdapter")PageAdapter pageAdapter,@Param("prodProp") ProdProp prodProp);

    long countPropAndValue(@Param("prodProp") ProdProp prodProp);

    int deleteByProdId(@Param("propId") Long propId,@Param("rule") Integer rule,@Param("shopId") Long shopId);

    ProdProp getProdPropByPropNameAndShopId(@Param("propName") String propName, @Param("shopId") Long shopId, @Param("rule") Integer rule);
}
