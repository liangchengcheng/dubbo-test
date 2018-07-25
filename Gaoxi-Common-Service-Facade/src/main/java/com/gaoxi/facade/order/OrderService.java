package com.gaoxi.facade.order;

import com.gaoxi.entity.order.OrdersEntity;
import com.gaoxi.req.order.OrderInsertReq;
import com.gaoxi.req.order.OrderQueryReq;

import java.util.List;

/**
 *
 */
public interface OrderService {

    List<OrdersEntity> findOrdersForBuyer(OrderQueryReq orderQueryReq, String buyerId);

    List<OrdersEntity> findOrdersForSeller(OrderQueryReq orderQueryReq, String sellerId);

    List<OrdersEntity> findOrdersForAdmin(OrderQueryReq orderQueryReq);

    String placeOrder(OrderInsertReq orderInsertReq, String buyerId);

    String pay(String orderId, String userId);

    void cancelOrder(String orderId, String userId);

    void confirmDelivery(String orderId, String expressNo, String userId);

    void confirmReceive(String orderId, String userId);

}
