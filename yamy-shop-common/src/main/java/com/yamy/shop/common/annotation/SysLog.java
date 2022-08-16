package com.yamy.shop.common.annotation;


import java.lang.annotation.*;

/**
 * @author 程祥
 * @date 2022/8/15 20:33
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
