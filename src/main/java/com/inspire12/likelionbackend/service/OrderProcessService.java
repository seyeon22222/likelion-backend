package com.inspire12.likelionbackend.service;

import com.inspire12.likelionbackend.config.aop.PerformanceCheck;
import com.inspire12.likelionbackend.model.entity.OrderStatus;
import com.inspire12.likelionbackend.model.request.OrderRequest;
import com.inspire12.likelionbackend.model.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class OrderProcessService {

    @PerformanceCheck
    public OrderResponse processOrder(OrderRequest orderRequest) {

        try {
            Thread.sleep(Duration.of(5, TimeUnit.SECONDS.toChronoUnit()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        OrderResponse orderResponse = OrderResponse.builder()
                .customerId(orderRequest.getCustomerId())
                .updatedAt(LocalDateTime.now())
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .orderNumber(UUID.randomUUID())
                .build();
        return orderResponse;
    }

}
