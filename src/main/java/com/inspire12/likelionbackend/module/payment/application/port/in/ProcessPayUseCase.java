package com.inspire12.likelionbackend.module.payment.application.port.in;

public interface ProcessPayUseCase {
    void processPayment(String paymentId, boolean isSuccess);
}
