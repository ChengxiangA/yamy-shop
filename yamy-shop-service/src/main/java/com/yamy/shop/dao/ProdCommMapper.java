package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yamy.shop.bean.model.ProdComm;
import org.apache.ibatis.annotations.Param;

/**
 * @author 程祥
 * @date 2022/8/27 13:10
 */
public interface ProdCommMapper extends BaseMapper<ProdComm> {
    IPage<ProdComm> getProdCommPage(@Param("page") Page page, @Param("prodComm") ProdComm prodComm);
}
