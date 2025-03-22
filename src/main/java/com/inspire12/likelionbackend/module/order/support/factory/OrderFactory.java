package com.inspire12.likelionbackend.module.order.support.factory;


import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;

import java.time.LocalDateTime;

public class OrderFactory {


    public static OrderResponse createResponse(Order order) {
        return OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    public static Order createOrder(OrderRequest orderRequest) {

        return Order.builder()
                .customerId(orderRequest.customerId())
                .storeId(orderRequest.storeId())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Order createOrder(OrderEntity orderEntity) {

        return Order.builder()
                .customerId(orderEntity.getCustomerId())
                .orderNumber(orderEntity.getOrderNumber())
                .totalOrderAmount(orderEntity.getTotalPrice())
                .storeId(orderEntity.getStoreId())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
