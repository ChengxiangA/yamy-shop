package com.yamy.shop.admin.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.ProdTag;
import com.yamy.shop.common.annotation.SysLog;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.security.admin.util.SecurityUtils;
import com.yamy.shop.service.ProdTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/18 9:12
 */
@RestController
@RequestMapping("/prod/prodTag")
public class ProdTagController {
    @Autowired
    private ProdTagService prodTagService;

    @GetMapping("/page")
    public ResponseEntity<IPage<ProdTag>> getProdTagPage(PageParam<ProdTag> page,ProdTag prodTag) {
        IPage<ProdTag> tagIPage = prodTagService.page(page, new LambdaQueryWrapper<ProdTag>()
                .eq(prodTag.getStatus() != null, ProdTag::getStatus, prodTag.getStatus())
                .like(prodTag.getTitle() != null, ProdTag::getTitle, prodTag.getTitle())
                .orderByDesc(ProdTag::getSeq));
        return ResponseEntity.ok(tagIPage);
    }

    /**
     * 通过ID查询商品分组
     * 点击修改的时候会使用这个接口
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<ProdTag> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(prodTagService.getById(id));
    }


    @SysLog("新增商品分类标签")
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid ProdTag prodTag) {
        List<ProdTag> list = prodTagService.list(new LambdaQueryWrapper<ProdTag>().like(ProdTag::getTitle, prodTag.getTitle()));
        // 找到模糊查询匹配的标签则抛出异常
        if(CollectionUtil.isNotEmpty(list)) {
            throw new YamyShopBindException("标签名称已存在，不能添加相同的标签");
        }
        prodTag.setProdCount(0L);
        prodTag.setIsDefault(0); // 商家新增
        prodTag.setCreateTime(new Date());
        prodTag.setUpdateTime(new Date());
        prodTag.setShopId(SecurityUtils.getSysUser().getShopId());
        return ResponseEntity.ok(prodTagService.save(prodTag));
    }

    @SysLog("修改商品分类标签")
    @PutMapping
    public ResponseEntity<Boolean> updateById(@RequestBody @Valid ProdTag prodTag) {
        if (prodTagService.getById(prodTag.getId()) == null) {
            throw new YamyShopBindException("没有找到找ID对应的标签");
        }
        prodTag.setUpdateTime(new Date());
        return ResponseEntity.ok(prodTagService.updateById(prodTag));
    }

    @SysLog("删除商品分类标签")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") String id) {
        ProdTag prodTag = prodTagService.getById(id);
        if(prodTag.getIsDefault() == 1) {
            throw new YamyShopBindException("默认标签不能删除");
        }
        return ResponseEntity.ok(prodTagService.removeById(id));
    }

    @GetMapping("/listTagList")
    public ResponseEntity<List<ProdTag>> listTagList() {
        return ResponseEntity.ok(prodTagService.listProdTag());
    }

}
