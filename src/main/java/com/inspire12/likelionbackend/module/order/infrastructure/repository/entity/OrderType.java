package com.inspire12.likelionbackend.module.order.infrastructure.repository.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderType {
    @JsonEnumDefaultValue DELIVERY,
    PICKUP
}
