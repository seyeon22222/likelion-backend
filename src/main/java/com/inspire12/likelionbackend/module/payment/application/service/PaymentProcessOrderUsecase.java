package com.inspire12.likelionbackend.module.payment.application.service;


import com.inspire12.likelionbackend.module.order.application.port.out.PaymentPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessOrderUsecase implements PaymentPort {
    @Override
    public boolean processPayment(Order order) {
        return false;
    }
}
