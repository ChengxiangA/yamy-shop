package com.yamy.shop.common.exception;

import com.yamy.shop.common.enums.YamyHttpStatus;
import org.springframework.http.HttpStatus;

/**
 * @author 程祥
 * @date 2022/8/18 12:48
 */
public class YamyShopBindException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer httpStatusCode;

    private Object object;

    public YamyShopBindException(YamyHttpStatus yamyHttpStatus) {
        super(yamyHttpStatus.getMsg());
        this.httpStatusCode = yamyHttpStatus.value();
    }

    public YamyShopBindException(YamyHttpStatus yamyHttpStatus,String msg) {
        super(msg);
        this.httpStatusCode = yamyHttpStatus.value();
    }

    public YamyShopBindException(String msg) {
        super(msg);
        this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
    }

    public YamyShopBindException(String msg, Object object) {
        super(msg);
        this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
        this.object = object;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
