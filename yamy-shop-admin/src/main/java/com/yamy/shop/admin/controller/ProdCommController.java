package com.yamy.shop.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.ProdComm;
import com.yamy.shop.common.annotation.SysLog;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.service.ProdCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/27 13:14
 */
@RestController
@RequestMapping("/prod/prodComm")
public class ProdCommController {
    @Autowired
    private ProdCommService prodCommService;

    @GetMapping("/page")
    public ResponseEntity<IPage<ProdComm>> getProdCommPage(PageParam<ProdComm> page,ProdComm prodComm) {
        return ResponseEntity.ok(prodCommService.getProdCommPage(page,prodComm));
    }

    @GetMapping("/info/{prodCommId}")
    public ResponseEntity<ProdComm> getById(@PathVariable("prodCommId") Long prodCommId) {
        return ResponseEntity.ok(prodCommService.getById(prodCommId));
    }


    @SysLog("新增商品评论")
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid ProdComm prodComm) {
        return ResponseEntity.ok(prodCommService.save(prodComm));
    }

    /**
     * 更新回复时间
     */
    @SysLog("修改商品评论")
    @PutMapping
    public ResponseEntity<Boolean> updateById(@RequestBody @Valid ProdComm prodComm) {
        prodComm.setReplyTime(new Date());
        return ResponseEntity.ok(prodCommService.updateById(prodComm));
    }

    @SysLog("删除商品评论")
    @DeleteMapping("/{prodCommId}")
    public ResponseEntity<Boolean> removeById(@PathVariable("prodCommId") Long prodCommId) {
        return ResponseEntity.ok(prodCommService.removeById(prodCommId));
    }

}
