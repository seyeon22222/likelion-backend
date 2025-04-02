package com.inspire12.likelionbackend.module.order.application.dto;

import com.inspire12.likelionbackend.module.order.enums.OrderStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderResponse(UUID orderNumber, OrderStatus orderStatus) {
}
