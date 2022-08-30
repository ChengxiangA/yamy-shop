package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.dto.HotSearchDto;
import com.yamy.shop.bean.model.HotSearch;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/24 23:30
 */
public interface HotSearchMapper extends BaseMapper<HotSearch> {
    List<HotSearchDto> getHotSearchByShopId(Long shopId);
}
