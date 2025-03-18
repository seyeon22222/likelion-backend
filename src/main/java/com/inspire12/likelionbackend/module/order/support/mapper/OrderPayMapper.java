package com.inspire12.likelionbackend.module.order.support.mapper;
import com.inspire12.likelionbackend.module.order.domain.Order;

import com.inspire12.likelionbackend.module.payment.application.dto.PayByOrderResult;

public class OrderPayMapper {

    public static PayByOrderResult toResult(Order order) {
        return new PayByOrderResult(
                order.getOrderNumber().toString(),
                order.getTotalOrderAmount(),
                order.getTotalPayedAmount(),
                order.getCustomerId(),
                order.getStoreId()
        );
    }
}
