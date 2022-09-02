package yamy.shop.security.common.permission;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;
import yamy.shop.security.common.util.AuthUserContext;

/**
 * 自定义权限校验方法
 * @author 程祥
 * @date 2022/8/31 11:44
 */
@Slf4j
@Component("pms")
public class PermissionService {
    public boolean hasPermission(String permission) {
        if (StrUtil.isBlank(permission)) {
            return false;
        }
        return AuthUserContext.get().getPerms()
                .stream()
                .filter(StringUtils::hasText)
                .anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x));
    }
}
