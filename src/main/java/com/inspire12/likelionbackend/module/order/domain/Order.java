package com.inspire12.likelionbackend.module.order.domain;

import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.DeliveryStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private OrderStatus orderStatus;

    private UUID orderNumber;

    private Long customerId;

    private Long totalOrderAmount;
    private Long totalPayedAmount;

    private Long storeId;

    // Delivery
    private OrderType orderType;
    @Nullable
    private Long deliveryId;
    @Nullable
    private DeliveryStatus deliveryStatus;

    private Long deliveryPrice = 0L;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
