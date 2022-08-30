package com.yamy.shop.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.HotSearch;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.security.admin.util.SecurityUtils;
import com.yamy.shop.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/24 23:44
 */
@RestController
@RequestMapping("/admin/hotSearch")
public class HotSearchController {
    @Autowired
    private HotSearchService hotSearchService;

    /**
     * 分页
     * @param hotSearch
     * @param page
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<IPage<HotSearch>> page(HotSearch hotSearch, PageParam<HotSearch> page) {
        IPage<HotSearch> hotSearchs = hotSearchService.page(page,new LambdaQueryWrapper<HotSearch>()
                .eq(HotSearch::getShopId, SecurityUtils.getSysUser().getShopId())
                .like(StrUtil.isNotBlank(hotSearch.getContent()),HotSearch::getContent,hotSearch.getContent())
                .like(StrUtil.isNotBlank(hotSearch.getTitle()),HotSearch::getTitle,hotSearch.getTitle())
                .eq(hotSearch.getStatus() != null,HotSearch::getStatus,hotSearch.getStatus())
                .orderByAsc(HotSearch::getSeq));
        return ResponseEntity.ok(hotSearchs);
    }

    /**
     * 根据热搜id查询热搜
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<HotSearch> info(@PathVariable("id") Long id) {
        HotSearch hotSearch = hotSearchService.getById(id);
        return ResponseEntity.ok(hotSearch);
    }

    /**
     * 更新
     * @param hotSearch
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid HotSearch hotSearch) {
        hotSearchService.updateById(hotSearch);
        //清除缓存
        hotSearchService.removeHotSearchDtoCacheByshopId(SecurityUtils.getSysUser().getShopId());
        return ResponseEntity.ok().build();
    }

    /**
     * 保存
     * @param hotSearch
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid HotSearch hotSearch) {
        hotSearch.setRecDate(new Date());
        hotSearch.setShopId(SecurityUtils.getSysUser().getShopId());
        hotSearchService.save(hotSearch);
        // 清除缓存
        hotSearchService.removeHotSearchDtoCacheByshopId(SecurityUtils.getSysUser().getShopId());
        return ResponseEntity.ok().build();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody List<Long> ids) {
        hotSearchService.removeByIds(ids);
        //清除缓存
        hotSearchService.removeHotSearchDtoCacheByshopId(SecurityUtils.getSysUser().getShopId());
        return ResponseEntity.ok().build();
    }
}
