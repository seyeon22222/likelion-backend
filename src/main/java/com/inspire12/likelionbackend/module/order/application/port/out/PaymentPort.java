package com.inspire12.likelionbackend.module.order.application.port.out;

import com.inspire12.likelionbackend.module.order.domain.Order;

public interface PaymentPort {
    boolean processPayment(Order order);
}
