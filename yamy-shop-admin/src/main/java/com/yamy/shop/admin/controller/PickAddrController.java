package com.yamy.shop.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.PickAddr;
import com.yamy.shop.common.enums.YamyHttpStatus;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.security.admin.util.SecurityUtils;
import com.yamy.shop.service.PickAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author 程祥
 * @date 2022/8/21 22:11
 */
@RestController
@RequestMapping("/shop/pickAddr")
public class PickAddrController {
    @Autowired
    private PickAddrService pickAddrService;

    /**
     * 分页获取
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<PickAddr>> page(PickAddr pickAddr, PageParam<PickAddr> page) {
        IPage<PickAddr> pickAddrPage = pickAddrService.page(page, new LambdaQueryWrapper<PickAddr>().eq(PickAddr::getShopId, SecurityUtils.getSysUser().getShopId())
                .eq(pickAddr.getAddrName() != null, PickAddr::getAddrName, pickAddr.getAddrName())
                .orderByDesc(PickAddr::getAddrId));
        return ResponseEntity.ok(pickAddrPage);
    }

    /**
     * 获取信息
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<PickAddr> info(@PathVariable("id") Long id) {
        PickAddr pickAddr = pickAddrService.getById(id);
        return ResponseEntity.ok(pickAddr);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid PickAddr pickAddr) {
        pickAddr.setShopId(SecurityUtils.getSysUser().getShopId());
        pickAddrService.save(pickAddr);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid PickAddr pickAddr) {
        PickAddr dbPickAddr = pickAddrService.getById(pickAddr.getAddrId());
        if (!Objects.equals(dbPickAddr.getShopId(),SecurityUtils.getSysUser().getShopId())) {
            throw new YamyShopBindException(YamyHttpStatus.UNAUTHORIZED);
        }
        pickAddrService.updateById(pickAddr);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Long[] ids) {
        pickAddrService.removeByIds(Arrays.asList(ids));
        return ResponseEntity.ok().build();
    }
}
