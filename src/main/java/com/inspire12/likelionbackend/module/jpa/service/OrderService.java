package com.inspire12.likelionbackend.module.jpa.service;

import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.repository.OrderJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;


    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        // TODO
        throw new EntityNotFoundException("주문 없음");
    }

    @Transactional
    public OrderResponse saveOrder(OrderRequest request) {
        // TODO
        throw new EntityNotFoundException("주문 없음");
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        // TODO
        throw new EntityNotFoundException("주문 없음");

    }

    @Transactional
    public OrderResponse updateTotalAmount(Long orderId, Integer newAmount) {
        // TODO
        throw new EntityNotFoundException("주문 없음");
    }
}
