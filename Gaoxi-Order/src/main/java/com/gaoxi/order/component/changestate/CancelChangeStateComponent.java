package com.gaoxi.order.component.changestate;

import com.gaoxi.enumeration.order.OrderStateEnum;
import org.springframework.stereotype.Component;

@Component
public class CancelChangeStateComponent extends BaseChangeStateComponent {

    @Override
    public void setTargetOrderState() {
        this.targetOrderState = OrderStateEnum.CANCEL;
    }
}
