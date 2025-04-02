package com.inspire12.likelionbackend.module.order.infrastructure.listener.event;



import com.inspire12.likelionbackend.module.order.enums.OrderStatus;

import java.util.UUID;


public record OrderToPaymentCompleteEvent(Long orderId,
                                          OrderStatus orderStatus,
                                          UUID orderNumber) {
}

