package com.inspire12.likelionbackend.module.order.infrastructure.adpter;

import com.inspire12.likelionbackend.exception.OrderNotExistException;
import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.OrderJpaRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import com.inspire12.likelionbackend.module.order.support.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final StoreStatusPort statusPort;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository, StoreStatusPort statusPort) {
        this.orderJpaRepository = orderJpaRepository;
        this.statusPort = statusPort;
    }

    public Order getOrderByOrderId(Long orderId) {
        if (statusPort.getStoreOpenStatus(orderId)) {
            OrderEntity orderEntity = orderJpaRepository.findById(orderId).orElseThrow(OrderNotExistException::new);
            return OrderMapper.fromEntity(orderEntity);
        }
        throw new OrderNotExistException();
    }


    @Override
    public Order getOrderByCustomerId(Long customerId) {
        return OrderMapper.fromEntity(orderJpaRepository.findByCustomerId(customerId));
    }

    @Override
    public Order getOrderByOrderNumber(String orderNumber) {

        throw new OrderNotExistException();
    }
}
