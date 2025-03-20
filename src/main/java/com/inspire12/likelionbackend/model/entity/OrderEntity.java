package com.inspire12.likelionbackend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @Column(name = "customer_id")
    private Long customerId;
//
//    @Column(name = "store_id")
//    private Long storeId;
//
//    @Column(name = "total_price")
//    private Long totalPrice;
//
//    @Column(name = "order_type")
//    @Enumerated(EnumType.STRING)
//    private OrderType orderType;
//
    @Column(name = "order_number")
    private UUID orderNumber;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "updated_at")
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedAt;

}