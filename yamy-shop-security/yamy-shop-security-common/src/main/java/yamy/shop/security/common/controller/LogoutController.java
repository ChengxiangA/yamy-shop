package yamy.shop.security.common.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import yamy.shop.security.common.manager.TokenStore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 程祥
 * @date 2022/9/1 13:26
 */
@RestController
public class LogoutController {
    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/logOut")
    @ApiOperation(value = "退出登陆", notes = "点击退出登陆，清除token，清除菜单缓存")
    public ResponseEntity<Void> logOut(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StrUtil.isBlank(accessToken)) {
            return ResponseEntity.ok().build();
        }
        // 删除该用户在该系统当前的token
        tokenStore.deleteCurrentToken(accessToken);
        return ResponseEntity.ok().build();
    }
}
