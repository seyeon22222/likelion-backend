package com.inspire12.likelionbackend.module.order.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderStatus {
    @JsonEnumDefaultValue PENDING_PAYMENT,

    SUCCESS_PAYMENT,
    CANCEL_PAYMENT,
    FAIL_PAYMENT,
    ORDERED,
    CANCELED,
}
