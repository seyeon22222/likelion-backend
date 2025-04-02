package com.inspire12.likelionbackend.testure;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.enums.OrderType;

public class OrderMockScenario {

    public static OrderRequest createDeliveryOrderRequest() {
        return new OrderRequest(
                1L, 2L, OrderType.DELIVERY
        );
    }
}
