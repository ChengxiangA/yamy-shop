package com.yamy.shop.common.handler;

import cn.hutool.core.util.CharsetUtil;
import com.yamy.shop.common.exception.YamyShopBindException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 程祥
 * @date 2022/8/31 14:31
 */
@Component
public class HttpHandler {
    private static final Logger logger = LoggerFactory.getLogger(HttpHandler.class);

    /**
     * 打印响应到web
     * @param str
     * @param status
     * @param <T>
     */
    public <T> void printServerResponseToWeb(String str, int status) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes == null) {
            logger.error("requestAttributes is null, can not print to web");
            return;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        if (response == null) {
            logger.error("httpServletResponse is null, can not print to web");
            return;
        }
        logger.error("response error: " + str);
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.write(str);
        }
        catch (IOException e) {
            throw new YamyShopBindException("io 异常", e);
        }
    }
}
