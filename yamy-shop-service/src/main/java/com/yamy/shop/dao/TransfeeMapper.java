package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.TransFee;
import com.yamy.shop.bean.model.TransfeeFree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/28 15:50
 */
public interface TransfeeMapper extends BaseMapper<TransFee> {
    void insertTransfees(List<TransFee> transfees);

    void insertTransfeeFrees(List<TransfeeFree> transfeeFrees);

    void deleteByTransportId(@Param("transportId") Long transportId);

    void deleteTransfeeFreesByTransportId(@Param("transportId") Long transportId);
}
