package com.inspire12.likelionbackend.module.payment.presentation.dto;


import com.inspire12.likelionbackend.module.payment.application.dto.PayCommand;
import com.inspire12.likelionbackend.module.payment.domain.PaymentProviderType;

public record PayRequest(
        String orderNumber,
        PaymentProviderType providerType
) {
    public PayCommand toCommand(Long customerId) {
        return new PayCommand(customerId, orderNumber(), providerType());
    }
}
