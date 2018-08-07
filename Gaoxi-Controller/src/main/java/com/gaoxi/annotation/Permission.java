package com.gaoxi.annotation;

import java.lang.annotation.*;

/**
 * 本注解用在Controller层的接口方法上，用于表示访问该接口所需的权限
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    public String value();
}
