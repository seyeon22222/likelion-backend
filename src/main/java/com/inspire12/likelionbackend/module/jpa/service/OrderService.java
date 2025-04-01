package com.inspire12.likelionbackend.module.jpa.service;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.mapper.OrderMapper;
import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.repository.OrderJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.hibernate.query.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;


    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        // TODO
        OrderEntity order = orderJpaRepository.findByOrderId(orderId).orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        return OrderMapper.fromEntity(order);
    }

    @Transactional
    public OrderResponse saveOrder(OrderRequest request) {
        // TODO
        if (request.getCustomerId() == null || request.getTotalAmount() == null) {
            throw new EntityNotFoundException("주문 없음");
        }
        OrderEntity order = OrderMapper.toEntity(request);
        orderJpaRepository.save(order);
        return OrderMapper.fromEntity(order);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        // TODO
        OrderEntity order = orderJpaRepository.findByOrderId(orderId).orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        orderJpaRepository.delete(order);
    }

    @Transactional
    public OrderResponse updateTotalAmount(Long orderId, Integer newAmount) {
        // TODO
        OrderEntity order = orderJpaRepository.findByOrderId(orderId).orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        order.changeTotalAmount(newAmount);
        return OrderMapper.fromEntity(order);
    }
}
