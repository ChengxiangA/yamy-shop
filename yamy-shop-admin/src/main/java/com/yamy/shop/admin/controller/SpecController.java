package com.yamy.shop.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.enums.ProdPropRule;
import com.yamy.shop.bean.model.ProdProp;
import com.yamy.shop.bean.model.ProdPropValue;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.security.admin.util.SecurityUtils;
import com.yamy.shop.service.ProdPropService;
import com.yamy.shop.service.ProdPropValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author 程祥
 * @date 2022/8/20 14:51
 * @description 规格管理
 */
@RestController
@RequestMapping("/prod/sec")
public class SpecController {
    @Autowired
    private ProdPropService prodPropService;

    @Autowired
    private ProdPropValueService prodPropValueService;

    /**
     * 分页获取
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<ProdProp>> page(ProdProp prodProp, PageParam<ProdProp> page) {
        prodProp.setRule(ProdPropRule.SPEC.value());
        prodProp.setShopId(SecurityUtils.getSysUser().getShopId());
        IPage<ProdProp> prodPropIPage = prodPropService.pagePropAndValue(prodProp, page);
        return ResponseEntity.ok(prodPropIPage);
    }

    /**
     * 获取所有规格
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProdProp>> list() {
        List<ProdProp> list = prodPropService.list(new LambdaQueryWrapper<ProdProp>().eq(ProdProp::getRule, ProdPropRule.SPEC.value()).eq(ProdProp::getShopId, SecurityUtils.getSysUser().getShopId()));
        return ResponseEntity.ok(list);
    }

    /**
     * 根据规格id 获取规格值
     */
    @GetMapping("/listSpecValue/{specId}")
    public ResponseEntity<List<ProdPropValue>> getSpecValueBySpecId(@PathVariable("specId") Long specId) {
        List<ProdPropValue> list = prodPropValueService.list(new LambdaQueryWrapper<ProdPropValue>().eq(ProdPropValue::getPropId, specId));
        return ResponseEntity.ok(list);
    }

    /**
     * 保存
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ProdProp prodProp) {
        prodProp.setRule(ProdPropRule.SPEC.value());
        prodProp.setShopId(SecurityUtils.getSysUser().getShopId());
        prodPropService.save(prodProp);
        return ResponseEntity.ok().build();
    }

    /**
     * 修改
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid ProdProp prodProp) {
        ProdProp byId = prodPropService.getById(prodProp.getShopId());
        if(!Objects.equals(byId,SecurityUtils.getSysUser().getShopId())) {
            throw new YamyShopBindException("没有权限获取该商品规格信息");
        }
        prodProp.setRule(ProdPropRule.SPEC.value());
        prodProp.setShopId(SecurityUtils.getSysUser().getShopId());
        prodPropService.updateProdPropAndValues(prodProp);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        prodPropService.deleteProdPropAndValues(id,ProdPropRule.SPEC.value(), SecurityUtils.getSysUser().getShopId());
        return ResponseEntity.ok().build();
    }


    /**
     * 获取规格属性最大的属性值ID
     */
    @GetMapping("/listSpecMaxValueId")
    public ResponseEntity<Long> listSpecMaxValueId() {
        ProdPropValue propValue = prodPropValueService.getOne(new LambdaQueryWrapper<ProdPropValue>().orderByDesc(ProdPropValue::getValueId).last("limit 1"));
        return ResponseEntity.ok(Objects.isNull(propValue) ? 0L : propValue.getValueId());
    }

}
