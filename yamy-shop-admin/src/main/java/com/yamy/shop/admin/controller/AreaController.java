package com.yamy.shop.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.enums.AreaLevelEnum;
import com.yamy.shop.bean.model.Area;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/21 1:52
 */
@RestController
@RequestMapping("/admin/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<Area>> page(Area area, PageParam<Area> page) {
        IPage<Area> areaPage = areaService.page(page, new LambdaQueryWrapper<Area>());
        return ResponseEntity.ok(areaPage);
    }

    /**
     * 获取省市
     */
    @GetMapping("/list")
    public ResponseEntity<List<Area>> list(Area area) {
        List<Area> list = areaService.list(new LambdaQueryWrapper<Area>().eq(area.getAreaName() != null, Area::getAreaName, area.getAreaName()));
        return ResponseEntity.ok(list);
    }

    /**
     * 通过父级ID获取区域列表
     */
    @GetMapping("/listByPid")
    public ResponseEntity<List<Area>> listByPid(Long pid) {
        List<Area> areas = areaService.listByPid(pid);
        return ResponseEntity.ok(areas);
    }

    /**
     * 获取区域信息通过区域Id
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public  ResponseEntity<Area> getByAreaId(@PathVariable("id") Long id) {
        Area area = areaService.getById(id);
        return ResponseEntity.ok(area);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid Area area) {
        if(area.getParentId() != null) {
            Area pArea = areaService.getById(area.getParentId());
            area.setLevel(pArea.getLevel() + 1);
            areaService.removeAreaCacheByParentId(area.getParentId());
        }
        areaService.save(area);
        return ResponseEntity.ok().build();
    }

    /**
     * 修改
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Area area) {
        Area areaDb = areaService.getById(area.getAreaId());
        if(areaDb == null) {
            throw new YamyShopBindException("地区不存在");
        }
        // 判断当前省市区级别，如果是1级、2级则不能修改级别，不能修改成别人的下级
        if(areaDb.getAreaId().equals(AreaLevelEnum.FIRST_LEVEL.value()) && !area.getAreaId().equals(AreaLevelEnum.FIRST_LEVEL.value())) {
            throw new YamyShopBindException("不能改变一级行政地区的级别");
        }
        if(areaDb.getAreaId().equals(AreaLevelEnum.SECOND_LEVEL.value()) && !area.getAreaId().equals(AreaLevelEnum.SECOND_LEVEL.value())) {
            throw new YamyShopBindException("不能改变二级行政地区的级别");
        }
        hasSameName(area);
        areaService.updateById(area);
        areaService.removeAreaCacheByParentId(area.getParentId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Area area = areaService.getById(id);
        areaService.removeById(id);
        areaService.removeAreaCacheByParentId(area.getParentId());
        return ResponseEntity.ok().build();
    }

    /**
     * 判断是否存在相同地区
     */
    private void hasSameName(Area area) {
        int count = areaService.count(new LambdaQueryWrapper<Area>()
                .eq(Area::getParentId, area.getParentId())
                .eq(Area::getAreaName, area.getAreaName())
                .ne(Area::getAreaId, area.getAreaId()));
        if(count > 0) {
            throw new YamyShopBindException("地区已存在");
        }
    }
}
