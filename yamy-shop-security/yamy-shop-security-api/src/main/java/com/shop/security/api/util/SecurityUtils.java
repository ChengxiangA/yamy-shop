package com.shop.security.api.util;

import com.shop.security.api.model.YamyUser;
import com.yamy.shop.common.util.HttpContextUtils;
import yamy.shop.security.common.bo.UserInfoInTokenBO;
import yamy.shop.security.common.util.AuthUserContext;

/**
 * @author 程祥
 * @date 2022/8/31 16:43
 */
public class SecurityUtils {
    public static final String USER_REQUEST = "/P/**";

    public YamyUser getUser() {
        if (!HttpContextUtils.getHttpServletRequest().getRequestURI().startsWith(USER_REQUEST)) {
            // 用户相关的请求，应该以/p开头！！！
            throw new RuntimeException("Yamy.user.request.error");
        }
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        YamyUser YamyUser = new YamyUser();
        YamyUser.setUserId(userInfoInTokenBO.getUserId());
        YamyUser.setBizUserId(userInfoInTokenBO.getBizUserId());
        YamyUser.setEnabled(userInfoInTokenBO.getEnabled());
        YamyUser.setShopId(userInfoInTokenBO.getShopId());
        YamyUser.setStationId(userInfoInTokenBO.getOtherId());
        return YamyUser;
    }
}
