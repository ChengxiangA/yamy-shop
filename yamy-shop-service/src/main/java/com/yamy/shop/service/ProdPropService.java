package com.yamy.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.ProdProp;
import com.yamy.shop.common.util.PageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

/**
 * @author 程祥
 * @date 2022/8/20 14:53
 */
public interface ProdPropService extends IService<ProdProp> {
    IPage<ProdProp> pagePropAndValue(ProdProp prodProp,PageParam<ProdProp> page);

    void deleteProdPropAndValues(@Param("id") Long id,@Param("rule") Integer rule,Long shopId);

    void updateProdPropAndValues(ProdProp prodProp);

    void saveProdPropAndValues(ProdProp prodProp);
}
