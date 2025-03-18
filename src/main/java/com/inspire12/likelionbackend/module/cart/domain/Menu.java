package com.inspire12.likelionbackend.module.cart.domain;

public record Menu(
        Long storeId,
        Long menuId,
        String menuName,
        int price
) {

}
