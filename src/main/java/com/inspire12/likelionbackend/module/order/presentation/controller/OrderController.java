package com.inspire12.likelionbackend.module.order.presentation.controller;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.application.service.OrderService;
import com.inspire12.likelionbackend.module.order.domain.Order;
import org.springframework.web.bind.annotation.*;


@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderService orderUsecase;

    public OrderController(OrderService orderUsecase) {
        this.orderUsecase = orderUsecase;
    }

    @GetMapping
    public OrderResponse getOrder(@RequestParam Long orderId) {
        return orderUsecase.getOrderByOrderId(orderId);
    }

    /**
     * Handles POST requests for creating an order.
     *
     * @param orderRequest the request body containing order details
     * @return a string indicating the outcome of the order process
     */
    @PostMapping
    public OrderResponse doOrder(@RequestBody OrderRequest orderRequest) {
        // Process the order request using the order service

        Order order = orderUsecase.confirmOrderPaymentCase2(orderRequest);
        OrderResponse orderResponse = OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderNumber(order.getOrderNumber())
                .build();

        // Return a confirmation string
        return orderResponse;
    }
}
