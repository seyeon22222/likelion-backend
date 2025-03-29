package com.inspire12.likelionbackend.module.jpa.controller;

import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public OrderResponse getOrder(@RequestParam Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.saveOrderByUserId(orderRequest.getCustomerId());
    }
}
