package yamy.shop.security.common.adapter;

import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/31 14:24
 */
public interface AuthConfigAdapter {
    /**
     * 也许需要登录才可用的url
     */
    String MAYBE_AUTH_URI = "/**/ma/**";

    /**
     * 需要授权登陆的路径
     * @return 需要授权登陆的路径列表
     */
    List<String> pathPatterns();

    /**
     * 不需要授权登陆的路径
     * @return 不需要授权登陆的路径列表
     */
    List<String> excludePathPatterns();
}