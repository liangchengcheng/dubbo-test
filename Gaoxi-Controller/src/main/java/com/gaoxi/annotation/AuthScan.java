package com.gaoxi.annotation;

import java.lang.annotation.*;

/**
 * 本注解用于指定扫描用户鉴权相关注解所在的包
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthScan {
    public String value();
}



