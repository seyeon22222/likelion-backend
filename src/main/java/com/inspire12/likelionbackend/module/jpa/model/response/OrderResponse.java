package com.inspire12.likelionbackend.module.jpa.model.response;


import com.inspire12.likelionbackend.module.jpa.model.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long customerId;
    private UUID orderNumber;

//    private OrderType orderType;

    private OrderStatus orderStatus;
    private LocalDateTime updatedAt;

}

