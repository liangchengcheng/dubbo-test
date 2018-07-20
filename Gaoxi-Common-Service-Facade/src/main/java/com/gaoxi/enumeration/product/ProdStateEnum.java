package com.gaoxi.enumeration.product;

import com.gaoxi.enumeration.BaseEnum;

/**
 * 产品状态的枚举
 */
public enum ProdStateEnum implements BaseEnum {

    OPEN(1, "上架"),
    CLOSE(2, "下架");

    private int code;
    private String msg;

    ProdStateEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
