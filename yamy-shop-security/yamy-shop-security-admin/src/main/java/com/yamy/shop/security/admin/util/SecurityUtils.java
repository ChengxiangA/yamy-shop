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
        YamySysUser yamySysUser = new YamySysUser();
        yamySysUser.setUserId(Long.valueOf(yamySysUser.getUserId()));
        yamySysUser.setAuthorities(userInfoInTokenBO.getPerms());
        yamySysUser.setUsername(userInfoInTokenBO.getNickName());
        yamySysUser.setEnabled(userInfoInTokenBO.getEnabled());
        yamySysUser.setShopId(userInfoInTokenBO.getShopId());
        return yamySysUser;
    }
}
