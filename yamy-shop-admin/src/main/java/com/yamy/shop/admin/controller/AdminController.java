package com.yamy.shop.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.security.admin.dto.CaptchaAuthenticationDTO;
import com.yamy.shop.sys.constant.Constant;
import com.yamy.shop.sys.model.SysMenu;
import com.yamy.shop.sys.model.SysUser;
import com.yamy.shop.sys.service.SysMenuService;
import com.yamy.shop.sys.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yamy.shop.security.common.bo.UserInfoInTokenBO;
import yamy.shop.security.common.enums.SysTypeEnum;
import yamy.shop.security.common.manager.PasswordCheckManager;
import yamy.shop.security.common.manager.PasswordManager;
import yamy.shop.security.common.manager.TokenStore;
import yamy.shop.security.common.vo.TokenInfoVO;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@Api(tags = "登录")
public class AdminController {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private PasswordCheckManager passwordCheckManager;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private PasswordManager passwordManager;

    @PostMapping("/adminLogin")
    public ResponseEntity<?> login(@RequestBody @Valid CaptchaAuthenticationDTO captchaAuthenticationDTO) {
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification(captchaAuthenticationDTO.getCaptchaVerification());
        ResponseModel response = captchaService.check(captchaVO);
        if(!response.isSuccess()) {
            return ResponseEntity.badRequest().body("验证码有误或已过期");
        }
        SysUser sysUser = sysUserService.getByUserName(captchaAuthenticationDTO.getUserName());
        if (sysUser == null) {
            throw new YamyShopBindException("账号或密码不正确");
        }
        String decryptPassword = passwordManager.decryptPassword(captchaAuthenticationDTO.getPassWord());
        passwordCheckManager.checkPassword(SysTypeEnum.ADMIN,captchaAuthenticationDTO.getUserName(), decryptPassword, sysUser.getPassword());
        // 不是店铺超级管理员，并且是禁用状态，无法登录
        if (Objects.equals(sysUser.getStatus(),0)) {
            // 未找到此用户信息
            throw new YamyShopBindException("未找到此用户信息");
        }
        UserInfoInTokenBO userInfoInToken = new UserInfoInTokenBO();
        userInfoInToken.setUserId(String.valueOf(sysUser.getUserId()));
        userInfoInToken.setSysType(SysTypeEnum.ADMIN.value());
        userInfoInToken.setEnabled(sysUser.getStatus() == 1);
        userInfoInToken.setPerms(getUserPermissions(sysUser.getUserId()));
        userInfoInToken.setNickName(sysUser.getUsername());
        userInfoInToken.setShopId(sysUser.getShopId());
        // 存储token返回vo
        TokenInfoVO tokenInfoVO = tokenStore.storeAndGetVo(userInfoInToken);
        return ResponseEntity.ok(tokenInfoVO);
    }


    /**
     * 查询用户权限
     */
    private Set<String> getUserPermissions(Long userId) {
        List<String> permsList;
        if(userId == Constant.SUPER_ADMIN_ID) {
            List<SysMenu> list = sysMenuService.list();
            permsList = list.stream().map(SysMenu::getPerms).collect(Collectors.toList());
        } else {
            permsList = sysUserService.queryAllPerms(userId);
        }
        return permsList.stream().flatMap((perms)->{
                    if (StrUtil.isBlank(perms)) {
                        return null;
                    }
                    return Arrays.stream(perms.trim().split(StrUtil.COMMA));
                }
        ).collect(Collectors.toSet());
    }
}
