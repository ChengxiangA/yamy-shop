package com.yamy.shop.common.filter;

import com.yamy.shop.common.xss.XssWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 程祥
 * @date 2022/8/30 16:01
 */
// 直接加 component 是直接过滤全部请求
@Component
public class XSSFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        logger.info("uri:{}",req.getRequestURI());
        // xss过滤
        filterChain.doFilter(new XssWrapper(req), resp);
    }
}
