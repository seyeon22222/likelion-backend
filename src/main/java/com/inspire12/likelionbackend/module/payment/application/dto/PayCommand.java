package com.inspire12.likelionbackend.module.payment.application.dto;

import com.inspire12.likelionbackend.module.payment.domain.PaymentProviderType;

public record PayCommand(
        Long customerId,
        String orderNumber,
        PaymentProviderType providerType
) { }
