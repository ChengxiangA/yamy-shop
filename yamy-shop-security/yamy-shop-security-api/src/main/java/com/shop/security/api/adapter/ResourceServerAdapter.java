package com.shop.security.api.adapter;

import org.springframework.stereotype.Component;
import yamy.shop.security.common.adapter.DefaultAuthConfigAdapter;

import java.util.Collections;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/31 15:55
 */
@Component
public class ResourceServerAdapter extends DefaultAuthConfigAdapter {

    @Override
    public List<String> pathPatterns() {
        return Collections.singletonList("/p/*");
    }
}