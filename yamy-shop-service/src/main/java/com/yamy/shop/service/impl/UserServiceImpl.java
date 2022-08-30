package com.yamy.shop.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.bean.model.User;
import com.yamy.shop.bean.param.UserRegisterParam;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.RedisUtil;
import com.yamy.shop.dao.UserMapper;
import com.yamy.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 程祥
 * @date 2022/8/27 15:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 目的是为了缓存
     * @param userId
     * @return
     */
    @Override
    @Cacheable(cacheNames = "user", key = "#userId")
    public User getUserByUserId(String userId) {
        return userMapper.selectById(userId);
    }

    /**
     * key：value
     * 验证码：手机号
     * 原理是注册时，会在redis中生成一个随机验证码，value值为手机号
     * 为什么不是
     * 手机号：验证码
     * @param userRegisterParam
     * @param checkRegisterSmsFlag
     */
    @Override
    public void validate(UserRegisterParam userRegisterParam, String checkRegisterSmsFlag) {
        if(StrUtil.isBlank(userRegisterParam.getCheckRegisterSmsFlag())) {
            throw new YamyShopBindException("校验码已过期，请重新发送校验码校验");
        } else {
            String checkRegisterSmsFlagMobile = RedisUtil.get(checkRegisterSmsFlag);
            if(!Objects.equals(checkRegisterSmsFlagMobile,userRegisterParam.getMobile())) {
                throw new YamyShopBindException("验证码已过期，请重新发送验证码校验");
            }
        }
    }
}
