package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yamy.shop.bean.app.dto.NoticeDto;
import com.yamy.shop.bean.model.Notice;
import lombok.Data;

/**
 * @author 程祥
 * @date 2022/8/26 13:15
 */
public interface NoticeMapper extends BaseMapper<Notice> {
    Page<NoticeDto> pageNotice(Page<NoticeDto> page);
}
