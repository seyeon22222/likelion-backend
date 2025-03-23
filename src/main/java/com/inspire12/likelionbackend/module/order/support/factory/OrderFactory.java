package com.inspire12.likelionbackend.module.order.support.factory;


import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;

public class OrderFactory {
    public static OrderResponse createOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderNumber(order.getOrderNumber())
                .build();
    }

    public static Order createOrder(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .storeId(orderEntity.getStoreId())
                .createdAt(orderEntity.getCreatedAt())
                .updatedAt(orderEntity.getUpdatedAt())
                .orderStatus(orderEntity.getOrderStatus())
                .orderNumber(orderEntity.getOrderNumber())
                .build();
    }
}
