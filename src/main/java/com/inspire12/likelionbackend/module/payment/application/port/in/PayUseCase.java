package com.inspire12.likelionbackend.module.payment.application.port.in;


import com.inspire12.likelionbackend.module.payment.application.dto.PayCommand;

public interface PayUseCase {
    void pay(PayCommand command);
}
