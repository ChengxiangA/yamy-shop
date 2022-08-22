package com.yamy.shop.common.util;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @author 程祥
 * @date 2022/8/20 16:55
 */
@Data
public class PageAdapter {
    private int begin;

    private int size;

    public PageAdapter(Page page) {
        int[] startEnd = PageUtil.transToStartEnd((int) page.getCurrent() - 1, (int) page.getSize());
        this.begin = startEnd[0];
        this.size = startEnd[1];
    }
}
