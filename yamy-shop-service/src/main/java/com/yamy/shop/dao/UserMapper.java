package com.yamy.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yamy.shop.bean.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 程祥
 * @date 2022/8/27 15:58
 */
public interface UserMapper extends BaseMapper<User> {
    User getUserByUserMail(@Param("userMail") String userMail);

    User selectOneByUserName(@Param("userName") String userName);
}
