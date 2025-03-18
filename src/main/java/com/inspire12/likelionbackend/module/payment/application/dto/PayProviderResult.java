package com.inspire12.likelionbackend.module.payment.application.dto;

public record PayProviderResult(
        String paymentId,
        boolean isSuccess
) { }
