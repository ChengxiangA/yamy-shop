package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.app.dto.CategoryDto;
import com.yamy.shop.bean.model.Category;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/9/2 12:24
 */
public interface CategoryService extends IService<Category> {
    /**
     * 根据parentId获取分类
     * @param parentId 0 一级分类
     * @return
     */
    List<Category> listByParentId(Long parentId);

    /**
     * 获取用于页面表单展现的category列表，根据seq排序
     * @return
     */
    List<Category> tableCategory(Long shopId);

    /**
     * 保存分类、品牌、参数
     * @return
     */
    void saveCategroy(Category category);

    /**
     * 修改分类、品牌、参数
     * @return
     */
    void updateCategroy(Category category);

    /**
     * 删除分类、品牌、参数 以及分类对应的图片
     * @return
     */
    void deleteCategroy(Long categoryId);

    /**
     * 根据店铺id和层级，获取商品分类树
     * @param shopId
     * @param grade
     * @return
     */
    List<Category> treeSelect(Long shopId,int grade);

    List<CategoryDto> listCategoryDtoByShopId(Long shopId);
}
