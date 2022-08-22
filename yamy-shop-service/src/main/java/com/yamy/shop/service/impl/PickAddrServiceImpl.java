package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.PickAddr;
import com.yamy.shop.dao.PickAddrMapper;
import com.yamy.shop.service.PickAddrService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 程祥
 * @date 2022/8/21 21:55
 */
public class PickAddrServiceImpl extends ServiceImpl<PickAddrMapper, PickAddr> implements PickAddrService {
    @Autowired
    private PickAddrMapper pickAddrMapper;

    @Override
    public void deleteByIds(Long[] ids) {
        pickAddrMapper.deleteByIds(ids);
    }
}
