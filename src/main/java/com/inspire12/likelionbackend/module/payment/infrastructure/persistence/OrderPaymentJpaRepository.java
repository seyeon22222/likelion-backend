package com.inspire12.likelionbackend.module.payment.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderPaymentJpaRepository extends JpaRepository<OrderPaymentEntity, Long> {
    Optional<OrderPaymentEntity> findByOrderNumber(String orderNumber);
}
