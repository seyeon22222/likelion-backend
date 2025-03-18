package com.inspire12.likelionbackend.module.payment.application.dto;

public record PayProviderCommand(
        Long customerId,
        Long storeId,
        Long amount
) {
}