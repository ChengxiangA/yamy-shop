package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.ProdTag;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/18 8:53
 */
public interface ProdTagService extends IService<ProdTag> {
    List<ProdTag> listProdTag();

    void removeProdTag();
}
