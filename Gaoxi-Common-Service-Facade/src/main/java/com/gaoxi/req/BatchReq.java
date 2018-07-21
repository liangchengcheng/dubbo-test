package com.gaoxi.req;

import java.util.List;

/**
 * 批量请求
 */
public class BatchReq<T> extends AbsReq {

    /** 请求列表 */
    private List<T> reqList;

    public List<T> getReqList() {
        return reqList;
    }

    public void setReqList(List<T> reqList) {
        this.reqList = reqList;
    }
}
