package com.yamy.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.ProdComm;

/**
 * @author 程祥
 * @date 2022/8/27 13:11
 */
public interface ProdCommService extends IService<ProdComm> {
    IPage<ProdComm> getProdCommPage(Page page, ProdComm prodComm);
}
