package com.inspire12.likelionbackend.module.jpa.model.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderType {
    @JsonEnumDefaultValue DELIVERY,
    PICKUP
}