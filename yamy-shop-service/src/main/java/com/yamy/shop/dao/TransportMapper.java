package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.Transport;
import com.yamy.shop.bean.model.TransfeeFree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/27 16:45
 */
public interface TransportMapper extends BaseMapper<Transport> {
    Transport getTransportAndTransfeeAndTranscity(@Param("id") Long id);

    void deleteTransports(@Param("ids") Long[] ids);


    List<TransfeeFree> getTransfeeFreeAndTranscityFreeByTransportId(@Param("transportId") Long transportId);
}
