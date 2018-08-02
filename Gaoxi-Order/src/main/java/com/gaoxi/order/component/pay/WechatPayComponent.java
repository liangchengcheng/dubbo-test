package com.gaoxi.order.component.pay;

import com.gaoxi.context.OrderProcessContext;
import com.gaoxi.order.component.BaseComponent;
import org.springframework.stereotype.Component;

@Component
public class WechatPayComponent extends BaseComponent {
    @Override
    public void handle(OrderProcessContext orderProcessContext) {
        preHandle(orderProcessContext);
        // TODO 微信支付
        afterHandle(orderProcessContext);
    }
}
