package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/24 22:52
 */
@Data
@TableName("tz_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 登陆密码
     */
    private String loginPassword;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 手机号码
     */
    private String userMobile;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;

    /**
     * 注册时间
     */

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userRegtime;

    /**
     * 注册ip
     */
    private String usreRegip;

    /**
     * 最后一次登陆时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userLasttime;

    /**
     * 最后一次登录ip
     */
    private String userLastip;

    /**
     * 用户备注
     */
    private String userMemo;

    /**
     * 性别 M(男) F(女)
     */
    private String sex;

    /**
     * 出生年月
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String birthDate;

    /**
     * 头像路径
     */
    private String pic;

    /**
     * 状态 1正常 0无效
     */
    private Integer status;

    /**
     * 积分
     */
    private Integer score;
}
