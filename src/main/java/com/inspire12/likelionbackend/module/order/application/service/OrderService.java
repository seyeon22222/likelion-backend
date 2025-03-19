package com.inspire12.likelionbackend.module.order.application.service;

import com.inspire12.likelionbackend.exception.OrderNotExistException;
import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }


    public Order orderToPayment(OrderRequest orderRequest) {

//        Order order = orderRepository.save(shoppingCart, orderRequest);
//        return order
        throw new OrderNotExistException();
    }


    public Order getOrderByOrderNumber(String orderNumber) {
        return orderRepository.getOrderByOrderNumber(orderNumber);
    }
}
