package com.shop.security.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yamy.shop.bean.model.User;
import com.yamy.shop.common.exception.YamyShopBindException;
import com.yamy.shop.common.util.PrincipalUtil;
import com.yamy.shop.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yamy.shop.security.common.bo.UserInfoInTokenBO;
import yamy.shop.security.common.dto.AuthenticationDTO;
import yamy.shop.security.common.enums.SysTypeEnum;
import yamy.shop.security.common.manager.PasswordCheckManager;
import yamy.shop.security.common.manager.PasswordManager;
import yamy.shop.security.common.manager.TokenStore;
import yamy.shop.security.common.vo.TokenInfoVO;

import javax.validation.Valid;

/**
 * @author 程祥
 * @date 2022/8/31 16:46
 */
@RestController
public class LoginController {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordCheckManager passwordCheckManager;

    @Autowired
    private PasswordManager passwordManager;

    @PostMapping("/login")
    public ResponseEntity<TokenInfoVO> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        String mobileOrUserName = authenticationDTO.getUserName();
        User user = getUser(mobileOrUserName);
        String decryptPassword = passwordManager.decryptPassword(authenticationDTO.getPassWord());
        // 半小时内密码输入错误十次，已限制登录30分钟
        passwordCheckManager.checkPassword(SysTypeEnum.ORDINARY,mobileOrUserName,decryptPassword,user.getLoginPassword());
        UserInfoInTokenBO userInfoInToken = new UserInfoInTokenBO();
        userInfoInToken.setUserId(user.getUserId());
        userInfoInToken.setSysType(SysTypeEnum.ORDINARY.value());
        userInfoInToken.setEnabled(user.getStatus() == 1);
        // 存储token返回vo
        TokenInfoVO tokenInfoVO = tokenStore.storeAndGetVo(userInfoInToken);
        return ResponseEntity.ok(tokenInfoVO);
    }

    private User getUser(String mobileOrUserName) {
        User user = null;
        if(PrincipalUtil.isMobile(mobileOrUserName)) {
            user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserMobile, mobileOrUserName));
        }
        if(user == null) {
            user = userMapper.selectOneByUserName(mobileOrUserName);
        }
        if(user == null) {
            throw new YamyShopBindException("账号或密码不正确");
        }
        return user;
    }
}
