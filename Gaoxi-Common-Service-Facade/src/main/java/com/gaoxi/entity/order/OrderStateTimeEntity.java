package com.gaoxi.entity.order;

import com.gaoxi.enumeration.order.OrderStateEnum;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * 订单到达各个状态的时间
 */
public class OrderStateTimeEntity implements Serializable {

    /** 订单ID */
    private String orderId;

    /** 订单状态 */
    private OrderStateEnum orderStateEnum;

    /** 时间 */
    private Timestamp time;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStateEnum getOrderStateEnum() {
        return orderStateEnum;
    }

    public void setOrderStateEnum(OrderStateEnum orderStateEnum) {
        this.orderStateEnum = orderStateEnum;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderStateTimeEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderStateEnum=" + orderStateEnum +
                ", time=" + time +
                '}';
    }
}
