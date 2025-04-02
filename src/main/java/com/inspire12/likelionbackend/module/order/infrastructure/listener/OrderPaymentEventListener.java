package com.inspire12.likelionbackend.module.order.infrastructure.listener;

import com.inspire12.likelionbackend.module.order.infrastructure.listener.event.OrderToPaymentCompleteEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentEventListener {

    public void handleOrderEvent(OrderToPaymentCompleteEvent event) {

    }
}
