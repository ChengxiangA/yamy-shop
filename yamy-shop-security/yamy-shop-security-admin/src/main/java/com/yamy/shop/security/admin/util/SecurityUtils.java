package com.yamy.shop.security.admin.util;

import com.yamy.shop.security.admin.model.YamySysUser;
import yamy.shop.security.common.bo.UserInfoInTokenBO;
import yamy.shop.security.common.util.AuthUserContext;

/**s
 * @author 程祥
 * @date 2022/8/17 8:43
 */
public class SecurityUtils {
    /**
     * 获取会话用户
     * @return
     */
    public static YamySysUser getSysUser() {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        YamySysUser details = new YamySysUser();
        details.setUserId(Long.valueOf(userInfoInTokenBO.getUserId()));
        details.setEnabled(userInfoInTokenBO.getEnabled());
        details.setUsername(userInfoInTokenBO.getNickName());
        details.setAuthorities(userInfoInTokenBO.getPerms());
        details.setShopId(userInfoInTokenBO.getShopId());
        return details;
    }
}
