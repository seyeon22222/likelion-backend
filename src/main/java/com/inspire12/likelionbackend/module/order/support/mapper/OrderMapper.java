package com.inspire12.likelionbackend.module.order.support.mapper;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.enums.OrderStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderMapper {

    // Entity -> Domain
    public static Order fromEntity(OrderEntity entity) {
        return Order.builder()
                .id(entity.getId())
                .customerId(entity.getCustomerId())
                .storeId(entity.getStoreId())
                .orderNumber(entity.getOrderNumber())
                .totalAmount(entity.getTotalAmount())
                .orderStatus(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // Domain -> Entity
    public static OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.getId(),
                order.getCustomerId(),
                order.getOrderNumber(),
                order.getTotalAmount(),
                order.getCreatedAt(),
                order.getStoreId(),
                order.getOrderStatus()
        );
    }

    // Domain -> Response
    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(
                UUID.fromString(order.getOrderNumber()),
                order.getOrderStatus(),
                order.getTotalAmount().longValue()
        );
    }

    // Request -> Domain
    public static Order fromRequest(OrderRequest request) {
        return Order.builder()
                .customerId(request.customerId())
                .storeId(request.storeId())
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .createdAt(LocalDateTime.now())
                .orderNumber(UUID.randomUUID().toString())
                .totalAmount(0) // 초기 금액은 임시로 0으로 설정, 이후 변경 가능
                .build();
    }
}
