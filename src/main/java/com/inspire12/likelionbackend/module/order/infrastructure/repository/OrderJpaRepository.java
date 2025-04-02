package com.inspire12.likelionbackend.module.order.infrastructure.repository;

import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByOrderNumber(String uuid);
    OrderEntity findByCustomerId(Long customerId);
    Optional<OrderEntity> findById(Long orderId);
}
