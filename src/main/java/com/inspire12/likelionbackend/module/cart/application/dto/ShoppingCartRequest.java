package com.inspire12.likelionbackend.module.cart.application.dto;

public record ShoppingCartRequest(
        Long customerId,
        Long menuId
) {

}
