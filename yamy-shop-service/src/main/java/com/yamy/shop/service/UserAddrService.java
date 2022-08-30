package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.UserAddr;

/**
 * @author 程祥
 * @date 2022/8/28 23:14
 */
public interface UserAddrService extends IService<UserAddr> {

    // 获取用户默认的收货地址
    UserAddr getDefaultUserAddr(String userId);

    // 更改默认收货地址
    void updateDefaultUserAddr(Long addrId, String userId);

    // 删除收货地址
    void removeUserAddrByUserId(Long addrId, String userId);

    // 获取收货地址
    UserAddr getUserAddrByUserId(Long addrId, String userId);
}
