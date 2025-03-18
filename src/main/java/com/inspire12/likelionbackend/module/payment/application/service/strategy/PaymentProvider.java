package com.inspire12.likelionbackend.module.payment.application.service.strategy;

import com.inspire12.likelionbackend.module.payment.application.dto.PayProviderCommand;
import com.inspire12.likelionbackend.module.payment.application.dto.PayProviderResult;
import com.inspire12.likelionbackend.module.payment.domain.PaymentProviderType;

public interface PaymentProvider {
    boolean isSupport(PaymentProviderType providerType);
    PayProviderResult pay(PayProviderCommand command);
}
