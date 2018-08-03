package com.gaoxi.order.processor;

import com.gaoxi.order.annotation.InjectComponents;
import com.gaoxi.order.component.BaseComponent;
import com.gaoxi.order.component.changestate.CancelChangeStateComponent;
import com.gaoxi.order.component.checkparam.NoPrivateCheckParamComponent;
import com.gaoxi.order.component.idempotent.CancelOrderIdempotentComponent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 取消订单
 */
@Component
public class CancelOrderProcessor extends Processor {

    @InjectComponents({
            // 参数校验
            NoPrivateCheckParamComponent.class,
            // 幂等检查
            CancelOrderIdempotentComponent.class,
            // 状态流转
            CancelChangeStateComponent.class
    })


    /** 业务组件列表(当前处理器需要处理的组件列表) */
    protected List<BaseComponent> componentList;

    @Override
    protected void overrideSuperComponentList() {
        super.componentList = this.componentList;
    }
}
