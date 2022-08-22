package com.yamy.shop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.ProdProp;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageAdapter;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.dao.ProdPropMapper;
import com.yamy.shop.dao.ProdPropValueMapper;
import com.yamy.shop.service.ProdPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author 程祥
 * @date 2022/8/20 14:53
 */
public class ProdPropServiceImpl extends ServiceImpl<ProdPropMapper, ProdProp> implements ProdPropService {
    @Autowired
    private ProdPropMapper prodPropMapper;

    @Autowired
    private ProdPropValueMapper prodPropValueMapper;

    @Override
    public IPage<ProdProp> pagePropAndValue(ProdProp prodProp, PageParam<ProdProp> page) {
        page.setRecords(prodPropMapper.listPropAndValue(new PageAdapter(page), prodProp));
        page.setTotal(prodPropMapper.countPropAndValue(prodProp));
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProdPropAndValues(Long propId,Integer propRule,Long shopId) {
        int deleteRows = prodPropMapper.deleteByProdId(propId, propRule, shopId);
        if(deleteRows == 0) {
            return;
        }
        // 删除原有属性值
        prodPropValueMapper.deleteByPropId(propId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProdPropAndValues(ProdProp prodProp) {
        // 查找修改对应名称的属性
        ProdProp dbProdProp = prodPropMapper.getProdPropByPropNameAndShopId(prodProp.getPropName(), prodProp.getShopId(), prodProp.getRule());
        // 修改的属性名称存在并且是同一店铺
        if(dbProdProp != null && !Objects.equals(prodProp.getShopId(),dbProdProp.getShopId())) {
            throw new YamyShopBindException("已有相同名称规格");
        }
        prodPropMapper.updateById(prodProp);
        prodPropValueMapper.deleteByPropId(prodProp.getPropId());
        if(CollectionUtil.isEmpty(prodProp.getProdPropValueList())) {
            return;
        }
        prodPropValueMapper.insertProdPropValues(prodProp.getPropId(), prodProp.getProdPropValueList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProdPropAndValues(ProdProp prodProp) {
        ProdProp dbProdProp = prodPropMapper.getProdPropByPropNameAndShopId(prodProp.getPropName(), prodProp.getShopId(), prodProp.getRule());
        if(dbProdProp != null) {
            throw new YamyShopBindException("已有相同名称规格");
        }
        prodPropMapper.insert(prodProp);
        if(CollectionUtil.isEmpty(prodProp.getProdPropValueList())) {
            return;
        }
        prodPropValueMapper.insertProdPropValues(prodProp.getPropId(), prodProp.getProdPropValueList());
    }



}
