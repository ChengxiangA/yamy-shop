package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.ProdTag;
import com.yamy.shop.dao.ProdTagMapper;
import com.yamy.shop.service.ProdTagService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/18 8:56
 */
@Service("prodTagService")
public class ProdTagServiceImpl extends ServiceImpl<ProdTagMapper, ProdTag> implements ProdTagService {

    private ProdTagMapper prodTagMapper;

    @Override
    @Cacheable(cacheNames = "prodTag", key = "'prodTag'")
    public List<ProdTag> listProdTag() {
        return prodTagMapper.selectList(new LambdaQueryWrapper<ProdTag>()
                .eq(ProdTag::getStatus,1)
                .orderByDesc(ProdTag::getSeq));
    }

    @Override
    public void removeProdTag() {

    }
}
