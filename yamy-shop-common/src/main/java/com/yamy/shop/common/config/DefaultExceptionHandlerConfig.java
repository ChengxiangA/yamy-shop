package com.yamy.shop.common.config;

import com.yamy.shop.common.exception.YamyShopBindException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 程祥
 * @date 2022/8/22 13:56
 * @description 统一异常处理
 */
@Slf4j
@Controller
@RestControllerAdvice
public class DefaultExceptionHandlerConfig {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindExceptionHandler(BindException e) {
        log.error("BindException:", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException:", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(YamyShopBindException.class)
    public ResponseEntity<String> unauthorizedExceptionHandler(YamyShopBindException e){
        log.error("YamyShopBindException Message :{}",e.getMessage());
        return ResponseEntity.status(e.getHttpStatusCode()).body(e.getMessage());
    }
}
