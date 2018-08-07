package com.gaoxi.annotation;

import java.lang.annotation.*;

/**
 * 本注解用在Controller层的接口上，表示访问该接口所需的角色
 */

// 本注解只能用在方法上
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Role {
    public String value();
}
