package com.inspire12.likelionbackend.module.order.infrastructure.adpter;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;
import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.OrderJpaRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import com.inspire12.likelionbackend.module.order.support.factory.OrderFactory;
import com.inspire12.likelionbackend.module.order.support.mapper.OrderMapper;
import com.inspire12.likelionbackend.exception.OrderNotExistException;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final StoreStatusPort statusPort;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository, StoreStatusPort statusPort) {
        this.orderJpaRepository = orderJpaRepository;
        this.statusPort = statusPort;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderJpaRepository.findById(orderId)
                .map(OrderMapper::toInitDomain)
                .orElseThrow(OrderNotExistException::new);
    }

    @Override
    public boolean checkOrderValid(ShoppingCartSnapshot shoppingCart, OrderRequest orderRequest) {
        return true;
    }

    @Override
    public Order save(ShoppingCartSnapshot shoppingCart, OrderRequest orderRequest) {
        boolean isStoreOpen = statusPort.getStoreOpenStatus(orderRequest.storeId());
        if (!isStoreOpen) {
            throw new RuntimeException("Store is closed");
        }
        UUID orderNumber = UUID.randomUUID();
        OrderEntity orderEntity = OrderFactory.createEntityInitBeforeDelivery(shoppingCart, orderRequest.customerId(), orderRequest.storeId(), orderNumber, orderRequest.orderType());

        return OrderMapper.toInitDomain(orderJpaRepository.save(orderEntity));
    }

    @Override
    public Order getOrderByOrderNumber(String orderNumber) {
        return orderJpaRepository.findByOrderNumber(UUID.fromString(orderNumber));
    }
}
