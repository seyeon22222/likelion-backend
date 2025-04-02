package com.inspire12.likelionbackend.module.order.domain;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.enums.OrderStatus;
import com.inspire12.likelionbackend.module.order.support.factory.OrderFactory;
import com.inspire12.likelionbackend.testure.OrderMockScenario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void 결제가_성공한_후_주문상태_확인() {
        OrderRequest deliveryOrderRequest = OrderMockScenario.createDeliveryOrderRequest();
        Order order = OrderFactory.createOrder(deliveryOrderRequest);
        order.approvePayment(true);
        assertEquals(OrderStatus.SUCCESS_PAYMENT, order.getOrderStatus());
    }

    @Test
    void 결제가_실패한_후_주문상태_확인() {
        OrderRequest deliveryOrderRequest = OrderMockScenario.createDeliveryOrderRequest();
        Order order = OrderFactory.createOrder(deliveryOrderRequest);
        order.approvePayment(false);
        assertEquals(OrderStatus.FAIL_PAYMENT, order.getOrderStatus());
    }
}