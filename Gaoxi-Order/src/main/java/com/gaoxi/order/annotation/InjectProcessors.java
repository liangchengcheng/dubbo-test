package com.gaoxi.order.annotation;

import com.gaoxi.order.component.BaseComponent;
import com.gaoxi.order.processor.Processor;

import java.lang.annotation.*;

/**
 * 向ProcessEngine中注入所有的Processor
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectProcessors {
    public Class<? extends Processor>[] value();
}
