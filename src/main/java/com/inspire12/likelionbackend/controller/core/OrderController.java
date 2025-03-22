package com.inspire12.likelionbackend.controller.core;

import com.inspire12.likelionbackend.model.request.OrderRequest;
import com.inspire12.likelionbackend.model.response.OrderResponse;
import com.inspire12.likelionbackend.service.OrderProcessService;
import com.inspire12.likelionbackend.service.jpa.OrderService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderProcessService orderProcessService;

    public OrderController(OrderService orderService, OrderProcessService orderProcessService) {
        this.orderService = orderService;
        this.orderProcessService = orderProcessService;
    }

    @GetMapping
    public OrderResponse getOrder(@RequestParam Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {

        return orderService.saveOrderByUserId(orderRequest.getCustomerId());
    }

    @PostMapping("/aop")
    public OrderResponse processOrder(@RequestBody OrderRequest orderRequest) {
        return orderProcessService.processOrder(orderRequest);
    }
}
