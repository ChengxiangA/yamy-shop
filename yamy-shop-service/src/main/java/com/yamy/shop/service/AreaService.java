package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.Area;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/21 2:00
 */
public interface AreaService extends IService<Area> {
    List<Area> listByPid(Long pid);

    void removeAreaCacheByParentId(Long pid);
}
