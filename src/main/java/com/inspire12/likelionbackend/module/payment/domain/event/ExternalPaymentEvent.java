package com.inspire12.likelionbackend.module.payment.domain.event;

public record ExternalPaymentEvent(
        String paymentId,
        boolean isSuccess
) {
}
