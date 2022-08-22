package com.yamy.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.ProdPropValue;
import com.yamy.shop.dao.ProdPropValueMapper;
import com.yamy.shop.service.ProdPropValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 程祥
 * @date 2022/8/19 19:48
 */
@Service("prodPropValueService")
public class ProdPropValueServiceImpl extends ServiceImpl<ProdPropValueMapper, ProdPropValue> implements ProdPropValueService {
    @Autowired
    private ProdPropValueMapper prodPropValueMapper;
}
