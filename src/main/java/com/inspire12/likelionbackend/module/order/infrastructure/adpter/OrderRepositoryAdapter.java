package com.inspire12.likelionbackend.module.order.infrastructure.adpter;

import com.inspire12.likelionbackend.exception.OrderNotExistException;
import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.support.factory.OrderFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

//    private final OrderJpaRepository orderJpaRepository;
    private final StoreStatusPort statusPort;

    public OrderRepositoryAdapter(StoreStatusPort statusPort) {
        this.statusPort = statusPort;
    }

    @Override
    public Order getOrderById(Long orderId) {
        if (statusPort.getStoreOpenStatus(orderId)) {
            return OrderFactory();
        }
        throw new OrderNotExistException();
    }


    @Override
    public Order getOrderByOrderNumber(String orderNumber) {
        throw new OrderNotExistException();
    }
}
