package com.inspire12.likelionbackend.module.order.infrastructure.listener.event;


import com.inspire12.likelionbackend.module.order.enums.OrderStatus;


public record OrderToStoreEvent(OrderStatus orderStatus) {
}
