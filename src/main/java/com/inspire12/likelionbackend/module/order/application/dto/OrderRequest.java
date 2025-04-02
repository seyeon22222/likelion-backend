package com.inspire12.likelionbackend.module.order.application.dto;


import com.inspire12.likelionbackend.module.order.enums.OrderType;


public record OrderRequest(long customerId, long storeId, OrderType orderType) {
}
