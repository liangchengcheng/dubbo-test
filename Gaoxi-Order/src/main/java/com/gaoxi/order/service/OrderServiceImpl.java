package com.gaoxi.order.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.context.OrderProcessContext;
import com.gaoxi.entity.order.OrdersEntity;
import com.gaoxi.enumeration.order.ProcessReqEnum;
import com.gaoxi.exception.CommonBizException;
import com.gaoxi.exception.ExpCodeEnum;
import com.gaoxi.facade.order.OrderService;
import com.gaoxi.order.dao.OrderDAO;
import com.gaoxi.order.engine.ProcessEngine;
import com.gaoxi.req.order.OrderInsertReq;
import com.gaoxi.req.order.OrderProcessReq;
import com.gaoxi.req.order.OrderQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    /**
     * 订单受理引擎
     */
    @Autowired
    private ProcessEngine processEngine;


    @Override
    public List<OrdersEntity> findOrdersForBuyer(OrderQueryReq orderQueryReq, String buyerId) {
        // 参数校验
        checkParam(orderQueryReq, ExpCodeEnum.ORDERQUERYREQ_NULL);
        // 设置买家ID
        orderQueryReq.setBuyerId(buyerId);
        // 查询
        return orderDAO.findOrders(orderQueryReq);
    }

    @Override
    public List<OrdersEntity> findOrdersForSeller(OrderQueryReq orderQueryReq, String sellerId) {
        // 参数校验
        checkParam(orderQueryReq, ExpCodeEnum.ORDERQUERYREQ_NULL);

        // 设置卖家ID
        orderQueryReq.setSellerId(sellerId);

        // 查询卖家的订单
        return orderDAO.findOrders(orderQueryReq);
    }

    @Override
    public List<OrdersEntity> findOrdersForAdmin(OrderQueryReq orderQueryReq) {
        // 参数校验
        checkParam(orderQueryReq, ExpCodeEnum.ORDERQUERYREQ_NULL);

        // 查询
        return orderDAO.findOrders(orderQueryReq);
    }

    @Override
    public String placeOrder(OrderInsertReq orderInsertReq, String buyerId) {
        // 参数校验
        checkParam(orderInsertReq, ExpCodeEnum.ORDER_INSERT_REQ_NULL);
        // 构造受理上下文
        orderInsertReq.setUserId(buyerId);
        OrderProcessContext<String> context = buildContext(null, buyerId, orderInsertReq, ProcessReqEnum.PlaceOrder);

        // 受理下单请求
        processEngine.process(context);

        // 获取结果
        return context.getOrderProcessRsp();
    }

    /**
     * 支付订单
     */
    @Override
    public String pay(String orderId, String userId) {
        // 构造受理上下文
        OrderProcessContext<String> context = buildContext(orderId, userId,null, ProcessReqEnum.Pay);
        // 受理下单请求
        processEngine.process(context);
        // 获取结果
        return context.getOrderProcessRsp();
    }

    /**
     * 退单
     */
    @Override
    public void cancelOrder(String orderId, String userId) {
        // 构造受理上下文
        OrderProcessContext<String> context = buildContext(orderId, userId,null, ProcessReqEnum.CancelOrder);
        // 受理下单请求
        processEngine.process(context);
    }

    @Override
    public void confirmDelivery(String orderId, String expressNo, String userId) {
        // 构造受理上下文
        OrderProcessContext<String> context = buildContext(orderId, userId, expressNo, ProcessReqEnum.ConfirmDelivery);
        // 受理下单请求
        processEngine.process(context);
    }

    /**
     * 确认收货
     */
    @Override
    public void confirmReceive(String orderId, String userId) {
        // 构造受理上下文
        OrderProcessContext<String> context = buildContext(orderId, userId,null, ProcessReqEnum.ConfirmReceive);
        // 受理下单请求
        processEngine.process(context);
    }

    /**
     * 请求参数校验
     * @param req 请求参数
     * @param expCodeEnum 异常枚举
     * @param <T> 请求参数类型
     */
    private <T> void checkParam (T req, ExpCodeEnum expCodeEnum) {
        if (req == null) {
            throw new CommonBizException(expCodeEnum);
        }
    }

    /**
     * 构建context
     */
    private <T> OrderProcessContext<String> buildContext(String orderId, String userId, T reqData, ProcessReqEnum processReqEnum) {
        // 订单受理上下文
        OrderProcessContext context = new OrderProcessContext();
        // 订单受理请求
        OrderProcessReq req = new OrderProcessReq();
        // 订单受理请求枚举(确认订单、退单、付款订单)
        req.setProcessReqEnum(processReqEnum);
        // 设置用户id
        req.setUserId(userId);

        if (StringUtils.isNotEmpty(orderId)) {
            req.setOrderId(orderId);
        }

        if (reqData != null) {
            req.setReqData(reqData);
        }

        context.setOrderProcessReq(req);
        return context;
    }
}
