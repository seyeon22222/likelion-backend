package com.inspire12.likelionbackend.module.jpa.service;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum;
import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.mapper.OrderMapper;
import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderListResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSumResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSummaryResponse;
import com.inspire12.likelionbackend.module.jpa.repository.OrderJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    private final OrderJpaRepository orderJpaRepository;


    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        return OrderMapper.fromEntity(order);
    }

    @Transactional
    public OrderResponse saveOrder(OrderRequest request) {
        OrderEntity order = OrderMapper.toEntity(request);
        OrderEntity savedOrder = orderJpaRepository.save(order);
        return OrderMapper.fromEntity(savedOrder);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        orderJpaRepository.delete(order);
    }

    @Transactional
    public OrderResponse updateTotalAmount(Long orderId, Integer newAmount) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        order.changeTotalAmount(newAmount);
        return OrderMapper.fromEntity(order);
    }


    // 고객 ID로 주문 요약 정보 조회
    @Transactional(readOnly = true)
    public OrderSummaryResponse getOrderSummaries(Long customerId) {
        return new OrderSummaryResponse(orderJpaRepository.findOrderSummariesByCustomerId(customerId));
    }


    public OrderSumResponse getOrderSum(Long customerId) {
        OrderSum orderSum = orderJpaRepository.sumAmountByUserId(customerId);
        return new OrderSumResponse(orderSum.getCustomerId(), orderSum.getCount());
    }



    public OrderListResponse getOrderByPager(Pageable pageable) {
        /**  TODO **/
        // String jpql = "SELECT o FROM OrderEntity o order by o." + sortBy + " " + direction;
        // List<OrderEntity> resultList = em.createQuery(jpql, OrderEntity.class)
        //         .setFirstResult(page * size)
        //         .setMaxResults(size)
        //         .getResultList();
        // List<OrderResponse> orderResponses = new ArrayList<>();
        // for (OrderEntity orderEntity : resultList) {
        //     orderResponses.add(OrderMapper.fromEntity(orderEntity));
        // }
        Page<OrderEntity> orderEntities = orderJpaRepository.findAllBy(pageable);
        return new OrderListResponse(orderEntities.stream().map(OrderMapper::fromEntity).collect(Collectors.toList()));
    }
}