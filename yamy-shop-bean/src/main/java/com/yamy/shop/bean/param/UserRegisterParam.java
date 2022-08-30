package com.yamy.shop.bean.param;

import lombok.Data;

/**
 * @author 程祥
 * @date 2022/8/23 12:54
 */
@Data
public class UserRegisterParam {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String userMail;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 头像
     */
    private String img;

    /**
     * 校验登录注册验证码成功的标识
     */
    private String checkRegisterSmsFlag;

    /**
     * 当账号未绑定时，临时的uid
     */
    private String uid;

    /**
     * 用户id
     */
    private Long userId;
}
