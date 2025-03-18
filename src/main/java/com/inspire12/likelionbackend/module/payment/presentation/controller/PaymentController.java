package com.inspire12.likelionbackend.module.payment.presentation.controller;

import com.inspire12.likelionbackend.module.payment.application.port.in.PayUseCase;
import com.inspire12.likelionbackend.module.payment.presentation.dto.PayRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/payment")
@RestController
public class PaymentController {

    private final PayUseCase payUseCase;

    public PaymentController(PayUseCase payUseCase) {
        this.payUseCase = payUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> pay(
            @RequestBody PayRequest request
    ) {
        var customerId = 1L;
        payUseCase.pay(request.toCommand(customerId));
        return ResponseEntity.ok().build();
    }
}
