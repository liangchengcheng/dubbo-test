package com.gaoxi.exception;

import java.io.Serializable;

/**
 * 通常业务异常  根据业务状态码区分不同的业务异常
 */
public class CommonBizException extends RuntimeException implements Serializable {

    private ExpCodeEnum codeEnum;

    public CommonBizException(ExpCodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonBizException(){}

    public ExpCodeEnum getCodeEnum() {
        return codeEnum;
    }
}
