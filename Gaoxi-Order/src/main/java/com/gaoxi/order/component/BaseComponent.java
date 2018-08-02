package com.gaoxi.order.component;

import com.gaoxi.context.OrderProcessContext;

public abstract class BaseComponent {

    protected void preHandle(OrderProcessContext orderProcessContext) {

    }

    public abstract void handle(OrderProcessContext orderProcessContext);

    protected void afterHandle(OrderProcessContext orderProcessContext) {

    }
}
