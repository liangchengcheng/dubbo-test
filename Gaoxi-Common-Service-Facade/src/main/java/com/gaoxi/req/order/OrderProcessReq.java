package com.gaoxi.req.order;


import com.gaoxi.enumeration.order.ProcessReqEnum;
import com.gaoxi.req.AbsReq;

/**
 * 订单受理请求
 */
public class OrderProcessReq <T> extends AbsReq {

    /** 受理人ID */
    private String userId;

    /** 订单ID */
    private String orderId;

    /** 受理器枚举 */
    private ProcessReqEnum processReqEnum;

    /** 自定义的请求参数 */
    private T reqData;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProcessReqEnum getProcessReqEnum() {
        return processReqEnum;
    }

    public void setProcessReqEnum(ProcessReqEnum processReqEnum) {
        this.processReqEnum = processReqEnum;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }

    @Override
    public String toString() {
        return "OrderProcessReq{" +
                "userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", processReqEnum=" + processReqEnum +
                ", reqData=" + reqData +
                '}';
    }
}
