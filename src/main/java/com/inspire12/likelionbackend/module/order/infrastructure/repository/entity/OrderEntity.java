package com.inspire12.likelionbackend.module.order.infrastructure.repository.entity;

import com.inspire12.likelionbackend.module.order.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;    // 필수 칼럼으로 다시 추가됨

    @Column(unique = true, nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    private Integer totalAmount;

    private LocalDateTime createdAt;

    // 추가
    private Long storeId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING_PAYMENT;


    // 변경 메서드 (명시적 메서드로만 수정 허용)
    public void changeTotalAmount(Integer newAmount) {
        this.totalAmount = newAmount;
    }

}
