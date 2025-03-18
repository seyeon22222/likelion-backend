package com.inspire12.likelionbackend.module.payment.application.port.out;


import com.inspire12.likelionbackend.module.payment.domain.OrderPayment;

import java.util.Optional;

public interface GetOrderPaymentPort {
    Optional<OrderPayment> getOrderPayment(String orderNumber);
}
