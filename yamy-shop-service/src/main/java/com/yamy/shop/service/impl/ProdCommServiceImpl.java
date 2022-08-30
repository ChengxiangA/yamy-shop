package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.ProdComm;
import com.yamy.shop.dao.ProdCommMapper;
import com.yamy.shop.service.ProdCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 程祥
 * @date 2022/8/27 13:12
 */
@Service
public class ProdCommServiceImpl extends ServiceImpl<ProdCommMapper, ProdComm> implements ProdCommService {
    @Autowired
    private ProdCommMapper prodCommMapper;

    @Override
    public IPage<ProdComm> getProdCommPage(Page page, ProdComm prodComm) {
        return prodCommMapper.getProdCommPage(page,prodComm);
    }
}
