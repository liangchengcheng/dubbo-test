package com.gaoxi.order.component.checkparam;

import com.gaoxi.context.OrderProcessContext;
import org.springframework.stereotype.Component;

/**
 * 供那些没有特有参数校验的场景使用
 */
@Component
public class NoPrivateCheckParamComponent extends BaseCheckParamComponent {
    @Override
    protected void privateParamCheck(OrderProcessContext orderProcessContext) {
        // Noting to do
    }
}
