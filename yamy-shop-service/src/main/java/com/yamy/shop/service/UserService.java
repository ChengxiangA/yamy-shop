package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.User;
import com.yamy.shop.bean.param.UserRegisterParam;

/**
 * @author 程祥
 * @date 2022/8/27 15:58
 */
public interface UserService extends IService<User> {
    User getUserByUserId(String userId);

    void validate(UserRegisterParam userRegisterParam, String checkRegisterSmsFlag);
}
