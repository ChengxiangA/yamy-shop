package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.dto.HotSearchDto;
import com.yamy.shop.bean.model.HotSearch;
import com.yamy.shop.dao.HotSearchMapper;
import com.yamy.shop.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/24 23:41
 */
@Service
public class HotSearchServiceImpl extends ServiceImpl<HotSearchMapper, HotSearch> implements HotSearchService {
    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Override
    @Cacheable(cacheNames = "HotSearchDto", key = "#shopId")
    public List<HotSearchDto> getHotSearchDtoByShopId(Long shopId) {
        return hotSearchMapper.getHotSearchByShopId(shopId);
    }

    @Override
    @CacheEvict(cacheNames = "HotSearchDto", key = "#shopId")
    public void removeHotSearchDtoCacheByshopId(Long shopId) {

    }
}
