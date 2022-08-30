package com.yamy.shop.admin.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yamy.shop.bean.model.User;
import com.yamy.shop.common.util.PageParam;
import com.yamy.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/27 15:57
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页获取
     * @param user
     * @param page
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<User>> page(User user, PageParam<User> page) {
        IPage<User> userIPage = userService.page(page, new LambdaQueryWrapper<User>()
                .like(StrUtil.isNotBlank(user.getNickName()), User::getNickName, user.getNickName())
                .eq(user.getStatus() != null, User::getStatus, user.getStatus()));
        for (User userResult : userIPage.getRecords()) {
            userResult.setNickName(EmojiUtil.toUnicode(userResult.getNickName() == null ? "" : userResult.getNickName()));
        }
        return ResponseEntity.ok(userIPage);
    }

    /**
     * 根据ID查询指定用户
     * @param userId
     * @return
     */
    @GetMapping("/info/{userId}")
    public ResponseEntity<User> info(@PathVariable("userId") String userId) {
        User user = userService.getById(userId);
        user.setNickName(EmojiUtil.toUnicode(user.getNickName() == null ? "" : user.getNickName()));
        return ResponseEntity.ok(user);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody User user) {
        user.setModifyTime(new Date());
        user.setNickName(EmojiUtil.toAlias(user.getNickName() == null ? "" : user.getNickName()));
        userService.updateById(user);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除用户
     */
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody String[] userIds) {
        userService.removeByIds(Arrays.asList(userIds));
        return ResponseEntity.ok().build();
    }

}
