package com.inspire12.likelionbackend.module.order.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderType {
    @JsonEnumDefaultValue DELIVERY,
    PICKUP
}
