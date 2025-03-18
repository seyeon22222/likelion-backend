package com.inspire12.likelionbackend.module.order.application.port.out;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;

public interface ShoppingCartPort {
    ShoppingCartSnapshot getItems(Long customerId);
}
