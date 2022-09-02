package com.yamy.shop.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.Category;
import com.yamy.shop.dao.CategoryMapper;
import com.yamy.shop.service.AttachFileService;
import com.yamy.shop.service.CategoryService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AttachFileService attachFileService;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public List<Category> listByParentId(Long parentId) {
        return categoryMapper.listByParentId(parentId);
    }


    @Override
    public List<Category> tableCategory(Long shopId) {
        return categoryMapper.tableCategory(shopId);
    }

}
