package com.inspire12.likelionbackend.module.order.application.dto;


import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderType;

// TODO menu 목록은 cart에 저장된 정보로 가져올지 바로 요청을 받을지
public record OrderRequest(long customerId, long storeId, OrderType orderType) {
}
