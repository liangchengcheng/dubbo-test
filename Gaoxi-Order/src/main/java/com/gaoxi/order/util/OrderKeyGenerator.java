package com.gaoxi.order.util;

import com.gaoxi.utils.KeyGenerator;

/**
 * 订单主键生成器
 */
public class OrderKeyGenerator {

    private static final String ORDER_ID_PREFIX = "ORDER";

    public static String generateOrderKey() {
        return ORDER_ID_PREFIX + KeyGenerator.getKey();
    }

}