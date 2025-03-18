package com.inspire12.likelionbackend.module.payment.application.port.out;


import com.inspire12.likelionbackend.module.payment.application.dto.PayByOrderResult;

public interface GetOrderPort {
    PayByOrderResult getOrder(String orderNumber);
}
