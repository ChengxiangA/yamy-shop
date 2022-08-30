package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.UserAddr;
import org.apache.ibatis.annotations.Param;

/**
 * @author 程祥
 * @date 2022/8/28 23:17
 */
public interface UserAddrMapper extends BaseMapper<UserAddr> {
    UserAddr getDefaultUserAddr(@Param("userId") String userId);

    /**
     * 移除用户默认地址
     * @param userId
     */
    void removeDefaultUserAddr(@Param("userId") String userId);

    /**
     * 将地址设置为默认地址
     * @param addrId
     * @param userId
     */
    int setDefaultUserAddr(@Param("addrId") Long addrId, @Param("userId") String userId);

    UserAddr getUserAddrByUserIdAndAddrId(@Param("userId") String userId, @Param("addrId") Long addrId);
}
