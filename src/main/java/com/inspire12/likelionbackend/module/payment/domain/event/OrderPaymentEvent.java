package com.inspire12.likelionbackend.module.payment.domain.event;


import com.inspire12.likelionbackend.module.payment.domain.PaymentStatus;

public record OrderPaymentEvent(
        String orderNumber,
        PaymentStatus paymentStatus
) { }
