package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.PickAddr;

/**
 * @author 程祥
 * @date 2022/8/21 21:42
 */
public interface PickAddrService extends IService<PickAddr> {

    void deleteByIds(Long[] ids);

}
