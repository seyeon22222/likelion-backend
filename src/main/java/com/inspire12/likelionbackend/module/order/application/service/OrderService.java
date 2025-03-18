package com.inspire12.likelionbackend.module.order.application.service;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;
import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.port.out.ShoppingCartPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final ShoppingCartPort shoppingCartPort;
    private final OrderRepository orderRepository;

    public OrderService(ShoppingCartPort shoppingCartPort, OrderRepository orderRepository) {
        this.shoppingCartPort = shoppingCartPort;
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Transactional
    public Order orderToPayment(OrderRequest orderRequest) {
        ShoppingCartSnapshot shoppingCart = shoppingCartPort.getItems(orderRequest.customerId());

        Order order = orderRepository.save(shoppingCart, orderRequest);
        return order;
    }


    public Order getOrderByOrderNumber(String orderNumber) {
        return orderRepository.getOrderByOrderNumber(orderNumber);
    }
}
