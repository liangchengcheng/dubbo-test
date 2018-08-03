package com.gaoxi.order.component.idempotent;

import com.gaoxi.enumeration.order.OrderStateEnum;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 *
 */
@Component
public class CancelOrderIdempotentComponent extends BaseIdempotencyComponent {
    @Override
    protected void setAllowStateList() {
        this.allowStateList = Arrays.asList(OrderStateEnum.INIT, OrderStateEnum.BUYER_UNPAID);
    }
}
