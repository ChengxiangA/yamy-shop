package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.Area;
import com.yamy.shop.dao.AreaMapper;
import com.yamy.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/21 2:01
 */
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    @Cacheable(cacheNames = "area",key = "#pid")
    public List<Area> listByPid(Long pid) {
        return areaMapper.selectList(new LambdaQueryWrapper<Area>().eq(Area::getParentId,pid));
    }

    @Override
    @CacheEvict(cacheNames = "area",key = "#pid")
    public void removeAreaCacheByParentId(Long pid) {

    }
}
