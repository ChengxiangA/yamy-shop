package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.app.dto.ProductDto;
import com.yamy.shop.bean.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 程祥
 * @date 2022/8/19 12:58
 */
public interface ProductMapper extends BaseMapper<Product> {
    int updateStocks(@Param("prod") Product product);

    Product getProductByProdNameAndShopId(@Param("prodName") String prodName,@Param("shopId") Long shopId);

    /**
     * 对应商家ID商品减少库存
     * @param prodCollect
     */
    void returnStock(@Param("prodCollect") Map<Long,Integer> prodCollect);

}
