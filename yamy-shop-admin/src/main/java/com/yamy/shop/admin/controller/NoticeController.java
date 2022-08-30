package com.yamy.shop.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.Notice;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.security.admin.util.SecurityUtils;
import com.yamy.shop.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/26 15:40
 */
@RestController
@RequestMapping("/shop/notice")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/page")
    public ResponseEntity<IPage<Notice>> getNoticePage(PageParam<Notice> page,Notice notice) {
        IPage<Notice> noticeIPage = noticeService.page(page, new LambdaQueryWrapper<Notice>()
                .eq(notice.getStatus() != null, Notice::getStatus, notice.getStatus())
                .eq(notice.getIsTop() != null, Notice::getIsTop, notice.getIsTop())
                .like(notice.getTitle() != null, Notice::getTitle, notice.getTitle())
                .orderByDesc(Notice::getUpdateTime)
        );
        return ResponseEntity.ok(noticeIPage);
    }

    /**
     * 通过id查询公告详情
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<Notice> info(@PathVariable("id") Long id) {
        return ResponseEntity.ok(noticeService.getById(id));
    }

    /**
     * 新增公告
     * @param notice
     * @return
     */
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid Notice notice) {
        notice.setShopId(SecurityUtils.getSysUser().getShopId());
        if(notice.getStatus() == 1) {
            notice.setPublishTime(new Date());
        }
        notice.setUpdateTime(new Date());
        // 清除缓存
        noticeService.removeNoticeList();
        return ResponseEntity.ok(noticeService.save(notice));
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody @Valid Notice notice) {
        Notice noticeDb = noticeService.getById(notice.getId());
        // 试图修改不是当前账号对应shop_id的公告
        if(notice.getShopId() !=  SecurityUtils.getSysUser().getShopId() || noticeDb.getShopId() != notice.getShopId()) {
            throw new YamyShopBindException("没有权限修改！");
        }
        // 上架通知
        if(noticeDb.getStatus() == 0 && notice.getStatus() == 1) {
            notice.setPublishTime(new Date());
        }
        notice.setUpdateTime(new Date());
        noticeService.removeNoticeById(notice.getId());
        noticeService.removeNoticeList();
        return ResponseEntity.ok(noticeService.updateById(notice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeById(@PathVariable Long id) {
        Notice noticeDb = noticeService.getById(id);
        if(SecurityUtils.getSysUser().getShopId() != noticeDb.getShopId()) {
            throw new YamyShopBindException("没有权限修改！");
        }
        // 清除缓存
        noticeService.removeNoticeById(id);
        noticeService.removeNoticeList();
        return ResponseEntity.ok(noticeService.removeById(id));
    }


}
