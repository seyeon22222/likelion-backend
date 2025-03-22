package com.inspire12.likelionbackend.module.order.application.service;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.application.port.out.PaymentPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderStatus;
import com.inspire12.likelionbackend.module.order.support.factory.OrderFactory;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentPort paymentPort;

    public OrderService(OrderRepository orderRepository, PaymentPort paymentPort) {
        this.orderRepository = orderRepository;
        this.paymentPort = paymentPort;
    }

    public Order confirmOrderPaymentCase1(OrderRequest orderRequest) {
        // 주문 도메인 객체를 만들고
        Order order = orderRepository.getOrderByCustomerId(orderRequest.customerId());
        // 결제를 요청해 처리하고
        boolean isPaymentSuccess = paymentPort.processPayment(order);
        if (isPaymentSuccess) {
            order.setOrderStatus(OrderStatus.SUCCESS_PAYMENT);
        } else {
            order.setOrderStatus(OrderStatus.FAIL_PAYMENT);
        }
        return order;
    }

    public Order confirmOrderPaymentCase2(OrderRequest orderRequest) {
        // 주문 도메인 객체를 만들고
        Order order = orderRepository.getOrderByCustomerId(orderRequest.customerId());
        // 결제를 요청해 처리하고
        boolean isPaymentSuccess = paymentPort.processPayment(order);
        order.approvePayment(isPaymentSuccess);
        return order;
    }

    public OrderResponse getOrderByOrderId(Long orderId) {
        return OrderFactory.createResponse(orderRepository.getOrderByOrderId(orderId));
    }
}
