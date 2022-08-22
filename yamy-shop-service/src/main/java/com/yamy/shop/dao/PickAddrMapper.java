package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.PickAddr;
import org.apache.ibatis.annotations.Param;

/**
 * @author 程祥
 * @date 2022/8/21 21:56
 */
public interface PickAddrMapper extends BaseMapper<PickAddr> {
    void deleteByIds(@Param("ids") Long[] ids);
}
