package com.inspire12.likelionbackend.module.payment.application.service.strategy;

import com.inspire12.likelionbackend.module.payment.application.dto.PayProviderCommand;
import com.inspire12.likelionbackend.module.payment.application.dto.PayProviderResult;
import com.inspire12.likelionbackend.module.payment.domain.PaymentProviderType;
import org.springframework.stereotype.Component;

import static com.inspire12.likelionbackend.module.payment.domain.PaymentProviderType.MONEY;

@Component
public class MoneyPaymentProvider implements PaymentProvider {

    @Override
    public boolean isSupport(PaymentProviderType providerType) {
        return MONEY.equals(providerType);
    }

    @Override
    public PayProviderResult pay(PayProviderCommand command) {
        return null;
    }
}