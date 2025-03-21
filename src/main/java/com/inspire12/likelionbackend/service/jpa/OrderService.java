package com.inspire12.likelionbackend.service.jpa;

import com.inspire12.likelionbackend.model.entity.OrderEntity;
import com.inspire12.likelionbackend.model.entity.OrderStatus;
import com.inspire12.likelionbackend.model.response.OrderResponse;
import com.inspire12.likelionbackend.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final OrderJpaRepository orderJpaRepository;
//    private final OrderJpaEntityRepository orderJpaEntityRepository;

    public OrderResponse getOrderById(Long orderId) {

        OrderEntity orderEntity = orderJpaRepository.findById(orderId)
                .orElseThrow(RuntimeException::new);
//        OrderEntity orderEntity = orderJpaRepository.findByOrderId(orderId)
//                .orElseThrow(RuntimeException::new);

//        OrderEntity orderEntity = orderJpaEntityRepository.findByOrderId(orderId)
//                .orElseThrow(RuntimeException::new);

        OrderResponse orderResponse = OrderResponse.builder()
                .customerId(orderEntity.getCustomerId())
                .updatedAt(orderEntity.getUpdatedAt())
                .orderStatus(orderEntity.getOrderStatus())
                .orderNumber(orderEntity.getOrderNumber())
                .build();

        return orderResponse;
    }


    @Transactional("inspire12TransactionMananger")
    public OrderResponse saveOrderByUserId(Long userId) {
        log.info("request save order by userId: {}", userId);
        OrderEntity orderEntity = OrderEntity.builder()
                .customerId(userId)
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .updatedAt(LocalDateTime.now())
                .orderNumber(UUID.randomUUID()).build();
        OrderEntity orderSaved = orderJpaRepository.save(orderEntity);
        return OrderResponse.builder()
                .customerId(orderSaved.getCustomerId())
                .orderNumber(orderSaved.getOrderNumber())
                .updatedAt(LocalDateTime.now())
                .orderStatus(orderSaved.getOrderStatus()).build();
    }
}
