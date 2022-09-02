package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.Category;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/9/2 12:24
 */
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> listByParentId(Long parentId);

    List<Category> tableCategory(Long shopId);

    List<Category> listCategoryAndProdByShopId(Long shopId);
}
