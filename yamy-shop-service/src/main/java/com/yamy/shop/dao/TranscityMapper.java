package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.Transcity;
import com.yamy.shop.bean.model.TranscityFree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/28 15:59
 */
public interface TranscityMapper extends BaseMapper<Transcity> {

    void insertTranscities(@Param("transcities") List<Transcity> transcities);

    void insertTranscityFrees(@Param("transcityFrees") List<TranscityFree> transcityFrees);

    void deleteBatchByTransfeeIds(@Param("transfeeIds") List<Long> transfeeIds);

    void deleteBatchByTransfeeFreeIds(@Param("transfeeFreeIds") List<Long> transfeeFreeIds);
}
