package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.app.dto.NoticeDto;
import com.yamy.shop.bean.model.Notice;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/26 13:15
 */
public interface NoticeService extends IService<Notice> {
    List<Notice> listNotice();

    void removeNoticeList();

    Page<NoticeDto> pageNotice(Page<NoticeDto> page);

    Notice getNoticeById(Long noticeId);

    void removeNoticeById(Long noticeId);
}
