package com.yamy.shop.security.admin.adapter;

import org.springframework.stereotype.Component;
import yamy.shop.security.common.adapter.DefaultAuthConfigAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/31 15:50
 */
@Component
public class ResourceServerAdapter extends DefaultAuthConfigAdapter {
    // 不需要授权资源
    public static final List<String> EXCLUDE_PATH = Arrays.asList(
            "/webjars/**",
            "/swagger/**",
            "/v2/api-docs",
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/captcha/**",
            "/adminLogin");

    @Override
    public List<String> excludePathPatterns() {
        return EXCLUDE_PATH;
    }
}
