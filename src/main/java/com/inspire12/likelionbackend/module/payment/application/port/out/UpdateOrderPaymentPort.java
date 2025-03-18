package com.inspire12.likelionbackend.module.payment.application.port.out;


import com.inspire12.likelionbackend.module.payment.domain.OrderPayment;

public interface UpdateOrderPaymentPort {
    void updateOrderPayment(OrderPayment orderPayment);
}
