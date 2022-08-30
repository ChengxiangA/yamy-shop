package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.dto.HotSearchDto;
import com.yamy.shop.bean.model.HotSearch;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/24 23:40
 */
public interface HotSearchService extends IService<HotSearch> {
    List<HotSearchDto> getHotSearchDtoByShopId(Long shopId);

    void removeHotSearchDtoCacheByshopId(Long shopId);
}
