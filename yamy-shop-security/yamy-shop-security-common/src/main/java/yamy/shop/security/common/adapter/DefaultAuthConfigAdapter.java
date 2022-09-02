package yamy.shop.security.common.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/31 14:25
 */
public class DefaultAuthConfigAdapter implements AuthConfigAdapter{
    private static final Logger logger = LoggerFactory.getLogger(DefaultAuthConfigAdapter.class);

    public DefaultAuthConfigAdapter() {
        logger.info("not implement other AuthConfigAdapter, use DefaultAuthConfigAdapter... all url need auth...");
    }

    @Override
    public List<String> pathPatterns() {
        return Collections.singletonList("/*");
    }

    @Override
    public List<String> excludePathPatterns() {
        return Collections.emptyList();
    }
}
