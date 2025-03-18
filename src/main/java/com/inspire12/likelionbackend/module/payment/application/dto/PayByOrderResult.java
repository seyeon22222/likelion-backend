package com.inspire12.likelionbackend.module.payment.application.dto;

public record PayByOrderResult(
        String orderNumber,
        Long totalOrderAmount,
        Long totalPayedAmount,
        Long customerId,
        Long storeId
) { }